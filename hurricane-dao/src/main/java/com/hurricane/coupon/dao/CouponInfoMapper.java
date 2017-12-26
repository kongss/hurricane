package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.CouponInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CouponInfoMapper {

    int deleteByPrimaryKey(String uuid);

    int insert(CouponInfo record);

    int insertSelective(CouponInfo record);

    CouponInfo selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(CouponInfo record);

    int updateByPrimaryKey(CouponInfo record);

    int insertCouponBatch(List<CouponInfo> list);

    List<Map<String, Object>> selectCouponInfoList(HashMap<String, Object> map);
}