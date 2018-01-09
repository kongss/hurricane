package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.CouponLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CouponLogMapper {

    List<Map<String, Object>> getCouponReceiveRecordList(HashMap<String, Object> map);

    int deleteByPrimaryKey(String uuid);

    int insert(CouponLog record);

    int insertSelective(CouponLog record);

    CouponLog selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(CouponLog record);

    int updateByPrimaryKey(CouponLog record);
}