package com.lzy.dubbo.db.dto;

import javax.persistence.*;

@Table(name = "monitor_system")
public class MonitorSystem extends BaseDto {
    /**
     * 主机主键
            
            
     */
    @Id
    @Column(name = "system_key")
    private String systemKey;

    /**
     * 用户主键
     */
    @Column(name = "user_key")
    private String userKey;

    /**
     * ip地址
            
     */
    @Column(name = "ip_address")
    private String ipAddress;

    /**
     * 序列化默认编号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取主机主键
            
            
     *
     * @return system_key - 主机主键
            
            
     */
    public String getSystemKey() {
        return systemKey;
    }

    /**
     * 设置主机主键
            
            
     *
     * @param systemKey 主机主键
            
            
     */
    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey == null ? null : systemKey.trim();
    }

    /**
     * 获取用户主键
     *
     * @return user_key - 用户主键
     */
    public String getUserKey() {
        return userKey;
    }

    /**
     * 设置用户主键
     *
     * @param userKey 用户主键
     */
    public void setUserKey(String userKey) {
        this.userKey = userKey == null ? null : userKey.trim();
    }

    /**
     * 获取ip地址
            
     *
     * @return ip_address - ip地址
            
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * 设置ip地址
            
     *
     * @param ipAddress ip地址
            
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }
}