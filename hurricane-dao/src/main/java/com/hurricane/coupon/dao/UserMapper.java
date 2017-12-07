package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.User;

public interface UserMapper {

    int deleteByPrimaryKey(String uuid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}