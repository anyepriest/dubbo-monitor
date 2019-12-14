package com.lzy.dubboprovider.server;/*
 *@auther chenz
 *@date 19-12-12上午10:39
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.lzy.dubboapi.api.IDubboProvider;
import com.lzy.dubboapi.api.Response;
import com.lzy.mongodb.MongoDbUtils;
import com.lzy.redis.JedisUtil;
import org.bson.Document;

@Service(
        version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class DubboProvider implements IDubboProvider {

    @Override
    public Response sayHello() {

        MongoDbUtils mongoDbUtils=new MongoDbUtils();
    Document  document=mongoDbUtils.findById("collection_test","5df32ee4dc1956535c6464d3");
//        JedisUtil.setString("lwt","hello");
//        return new Response(JedisUtil.getString("lwt"));
        return new Response(document.getString("age"));
    }
}
