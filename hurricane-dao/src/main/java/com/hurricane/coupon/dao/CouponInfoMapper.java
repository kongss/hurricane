package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.CouponInfo;

public interface CouponInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_info
     *
     * @mbggenerated
     */
    int insert(CouponInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_info
     *
     * @mbggenerated
     */
    int insertSelective(CouponInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_info
     *
     * @mbggenerated
     */
    CouponInfo selectByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CouponInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CouponInfo record);
}