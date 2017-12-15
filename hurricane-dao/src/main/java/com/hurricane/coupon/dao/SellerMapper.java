package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.Seller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SellerMapper {

    int selectSellerTotal(HashMap<String, Object> map);

    List<Map<String, Object>> selectSellerList(HashMap<String, Object> map);

    int deleteByPrimaryKey(String uuid);

    int insert(Seller record);

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
}