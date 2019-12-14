package com.lzy.redis;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 烛火下的乌托邦
 */
public class JedisUtil {

    private JedisUtil() {}
    private static ReentrantLock lockPool = new ReentrantLock();
    // Redis服务器IP
    private static String HOST = "";
    // Redis的端口号
    private static int PORT = 0;
    private static String PASSWORD = null;
    // 可用连接实例的最大数目，默认值为8；
    // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 0;
    // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 0;
    // 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 0;
    // 超时时间
    private static int TIMEOUT = 0;
    // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = false;
    private static JedisPool jedisPool = null;

    /**
     * 加载redisPool的配置信息
     */
    static {
        try {
            InputStream stream = JedisUtil.class.getClassLoader().getResourceAsStream("application.properties");
            Properties ps = new Properties();
            ps.load(stream);
            HOST = ps.getProperty("spring.redis.host");
            PORT = Integer.parseInt(ps.getProperty("spring.redis.port"));
            TIMEOUT = Integer.parseInt(ps.getProperty("spring.redis.timeout"));
            MAX_WAIT = Integer.parseInt(ps.getProperty("spring.redis.jedis.pool.max-wait"));
            MAX_ACTIVE = Integer.parseInt(ps.getProperty("spring.redis.jedis.pool.max-active"));
            MAX_IDLE = Integer.parseInt(ps.getProperty("spring.redis.jedis.pool.max-idle"));
            PASSWORD = ps.getProperty("spring.redis.password");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("解析配置文件失败！");
        }
    }

    /**
     * 初始化Redis连接池
     */
    private static void initialPool() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            if (StringUtils.isBlank(PASSWORD)) {
                jedisPool = new JedisPool(config, HOST, PORT, TIMEOUT);
            } else {
                jedisPool = new JedisPool(config, HOST, PORT, TIMEOUT, PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("初始化连接池失败！");
        }
    }

    /**
     * 在多线程环境同步初始化，
     * redisPool只要一个就好了，所以要设置锁，保证只能初始化一个
     */
    private static void poolInit() {
        lockPool.lock();
        try {
            if (jedisPool == null) {
                initialPool();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPool.unlock();
        }
    }

    /**
     * 这里可以使用多线程进行加载，所以将锁去掉,
     * 保证了只有一个jedisPool，
     * @return
     */
    private static Jedis getJedis() {
        if (jedisPool == null) {
            poolInit();
        }
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getJedis() 方法出错：" + e.getMessage());
        } finally {
            close(jedis);
        }
        return jedis;
    }

    /**
     * 释放jedis资源
     * @param jedis
     */
    private static void close(final Jedis jedis) {
        try {
            if (jedis != null && jedisPool != null) {
                jedis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Jedis close() 方法出错");
        }
    }

    /**
     * 设置 String
     * @param key
     * @param value
     */
    public static void setString(String key, String value) {
        try {
            getJedis().set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Jedis setString() 方法出错");
        }
    }

    /**
     * 设置 过期时间
     * @param key
     * @param value
     * @param seconds 超时秒数
     */
    public static void setString(String key, String value, int seconds) {
        try {
            value = StringUtils.isBlank(value) ? "" : value;
            getJedis().setex(key, seconds, value);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Jedis setString() 方法出错");
        }
    }

    /**
     * 获取String值
     * @param key
     * @return value
     */
    public static String getString(String key) {
        String result = null;
        try {
            result = getJedis().get(key);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Jedis getString() 方法出错");
        }
        return result;
    }

    /**
     * 删除key的键值对
     * @param key
     * @return
     */
    public static void delString(String key) {
        try {
            getJedis().del(key);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getString() 方法出错");
        }
    }
}
