package com.lzy.dubbo.db.dto;

import java.util.Date;
import javax.persistence.*;

@Table(name = "monitor_user")
public class MonitorUser extends BaseDto {
    /**
     * 用户主键
            
     */
    @Id
    @Column(name = "user_key")
    private String userKey;

    /**
     * 姓名
            
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    @Column(name = "e_mail")
    private String eMail;

    /**
     * 电话
     */
    private String phone;

    /**
     * 状态
     */
    private String status;

    /**
     * 注册日期
            
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新日期
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 权限
     */
    private String role;

    /**
     * 序列化默认编号
     */
    private static final long serialVersionUID = 1L;

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
     * 获取姓名
            
     *
     * @return user_name - 姓名
            
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
            
     *
     * @param userName 姓名
            
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取邮箱
     *
     * @return e_mail - 邮箱
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * 设置邮箱
     *
     * @param eMail 邮箱
     */
    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取注册日期
            
     *
     * @return create_time - 注册日期
            
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置注册日期
            
     *
     * @param createTime 注册日期
            
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新日期
     *
     * @return update_time - 更新日期
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新日期
     *
     * @param updateTime 更新日期
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取权限
     *
     * @return role - 权限
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置权限
     *
     * @param role 权限
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}