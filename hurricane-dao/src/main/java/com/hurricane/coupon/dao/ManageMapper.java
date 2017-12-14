package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.Manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ManageMapper {

    Map<String, Object> selectManage(HashMap<String, Object> map);

    List<Map<String, Object>> selectManageList(HashMap<String, Object> map);

    int deleteByPrimaryKey(String uuid);

    int insert(Manage record);

    int insertSelective(Manage record);

    Manage selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Manage record);

    int updateByPrimaryKey(Manage record);
}