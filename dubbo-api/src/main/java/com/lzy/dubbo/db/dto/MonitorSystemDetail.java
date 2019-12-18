package com.lzy.dubbo.db.dto;

import javax.persistence.*;

@Table(name = "monitor_system_detail")
public class MonitorSystemDetail extends BaseDto {
    /**
     * 主机详细表主键
     */
    @Id
    @Column(name = "system_detail_key")
    private String systemDetailKey;

    /**
     * 主机主键
            
     */
    @Column(name = "system_key")
    private String systemKey;

    /**
     * 系统类型
            
            
     */
    @Column(name = "system_type")
    private String systemType;

    /**
     * 操作系统型号
            
     */
    @Column(name = "system_model")
    private String systemModel;

    /**
     * 系统状态
            
     */
    @Column(name = "system_status")
    private String systemStatus;

    /**
     * 启动时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 序列化默认编号
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取主机详细表主键
     *
     * @return system_detail_key - 主机详细表主键
     */
    public String getSystemDetailKey() {
        return systemDetailKey;
    }

    /**
     * 设置主机详细表主键
     *
     * @param systemDetailKey 主机详细表主键
     */
    public void setSystemDetailKey(String systemDetailKey) {
        this.systemDetailKey = systemDetailKey == null ? null : systemDetailKey.trim();
    }

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
     * 获取系统类型
            
            
     *
     * @return system_type - 系统类型
            
            
     */
    public String getSystemType() {
        return systemType;
    }

    /**
     * 设置系统类型
            
            
     *
     * @param systemType 系统类型
            
            
     */
    public void setSystemType(String systemType) {
        this.systemType = systemType == null ? null : systemType.trim();
    }

    /**
     * 获取操作系统型号
            
     *
     * @return system_model - 操作系统型号
            
     */
    public String getSystemModel() {
        return systemModel;
    }

    /**
     * 设置操作系统型号
            
     *
     * @param systemModel 操作系统型号
            
     */
    public void setSystemModel(String systemModel) {
        this.systemModel = systemModel == null ? null : systemModel.trim();
    }

    /**
     * 获取系统状态
            
     *
     * @return system_status - 系统状态
            
     */
    public String getSystemStatus() {
        return systemStatus;
    }

    /**
     * 设置系统状态
            
     *
     * @param systemStatus 系统状态
            
     */
    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus == null ? null : systemStatus.trim();
    }

    /**
     * 获取启动时间
     *
     * @return start_time - 启动时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置启动时间
     *
     * @param startTime 启动时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }
}