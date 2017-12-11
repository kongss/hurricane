package com.hurricane.coupon.dao;

import com.hurricane.coupon.entity.Seller;

public interface SellerMapper {

    int deleteByPrimaryKey(String uuid);

    int insert(Seller record);

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);
}