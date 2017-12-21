package com.hurricane.coupon.entity;

import java.io.Serializable;
import java.util.Date;

public class CouponInfo implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.uuid
     *
     * @mbggenerated
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.number
     *
     * @mbggenerated
     */
    private String number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.release_time
     *
     * @mbggenerated
     */
    private Date releaseTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column coupon_info.coupon_uuid
     *
     * @mbggenerated
     */
    private String couponUuid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.uuid
     *
     * @return the value of coupon_info.uuid
     *
     * @mbggenerated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.uuid
     *
     * @param uuid the value for coupon_info.uuid
     *
     * @mbggenerated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.number
     *
     * @return the value of coupon_info.number
     *
     * @mbggenerated
     */
    public String getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.number
     *
     * @param number the value for coupon_info.number
     *
     * @mbggenerated
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.code
     *
     * @return the value of coupon_info.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.code
     *
     * @param code the value for coupon_info.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.release_time
     *
     * @return the value of coupon_info.release_time
     *
     * @mbggenerated
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.release_time
     *
     * @param releaseTime the value for coupon_info.release_time
     *
     * @mbggenerated
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.status
     *
     * @return the value of coupon_info.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.status
     *
     * @param status the value for coupon_info.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column coupon_info.coupon_uuid
     *
     * @return the value of coupon_info.coupon_uuid
     *
     * @mbggenerated
     */
    public String getCouponUuid() {
        return couponUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column coupon_info.coupon_uuid
     *
     * @param couponUuid the value for coupon_info.coupon_uuid
     *
     * @mbggenerated
     */
    public void setCouponUuid(String couponUuid) {
        this.couponUuid = couponUuid == null ? null : couponUuid.trim();
    }
}