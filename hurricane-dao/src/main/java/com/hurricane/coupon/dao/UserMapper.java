package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<Map<String, Object>> selectUserList(HashMap<String, Object> map);

    int deleteByPrimaryKey(String uuid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}