package com.hurricane.coupon.entity;

import java.io.Serializable;
import java.util.Date;

public class ManageLog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_log.uuid
     *
     * @mbggenerated
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_log.login_time
     *
     * @mbggenerated
     */
    private Date loginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_log.login_ip
     *
     * @mbggenerated
     */
    private String loginIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_log.login_port
     *
     * @mbggenerated
     */
    private String loginPort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manage_log.login_uuid
     *
     * @mbggenerated
     */
    private String loginUuid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_log.uuid
     *
     * @return the value of manage_log.uuid
     *
     * @mbggenerated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_log.uuid
     *
     * @param uuid the value for manage_log.uuid
     *
     * @mbggenerated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_log.login_time
     *
     * @return the value of manage_log.login_time
     *
     * @mbggenerated
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_log.login_time
     *
     * @param loginTime the value for manage_log.login_time
     *
     * @mbggenerated
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_log.login_ip
     *
     * @return the value of manage_log.login_ip
     *
     * @mbggenerated
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_log.login_ip
     *
     * @param loginIp the value for manage_log.login_ip
     *
     * @mbggenerated
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_log.login_port
     *
     * @return the value of manage_log.login_port
     *
     * @mbggenerated
     */
    public String getLoginPort() {
        return loginPort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_log.login_port
     *
     * @param loginPort the value for manage_log.login_port
     *
     * @mbggenerated
     */
    public void setLoginPort(String loginPort) {
        this.loginPort = loginPort == null ? null : loginPort.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manage_log.login_uuid
     *
     * @return the value of manage_log.login_uuid
     *
     * @mbggenerated
     */
    public String getLoginUuid() {
        return loginUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manage_log.login_uuid
     *
     * @param loginUuid the value for manage_log.login_uuid
     *
     * @mbggenerated
     */
    public void setLoginUuid(String loginUuid) {
        this.loginUuid = loginUuid == null ? null : loginUuid.trim();
    }
}