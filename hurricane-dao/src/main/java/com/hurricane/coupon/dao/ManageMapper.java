package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.Manage;

public interface ManageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbggenerated
     */
    int insert(Manage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbggenerated
     */
    int insertSelective(Manage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbggenerated
     */
    Manage selectByPrimaryKey(String uuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Manage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manage
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Manage record);
}