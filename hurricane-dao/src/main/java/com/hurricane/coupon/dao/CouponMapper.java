package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.Coupon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CouponMapper {

    List<Map<String, Object>> selectCouponList(HashMap<String, Object> map);

    int deleteByPrimaryKey(String uuid);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}