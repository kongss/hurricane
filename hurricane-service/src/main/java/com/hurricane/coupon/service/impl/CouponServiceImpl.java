package com.hurricane.coupon.service.impl;

import com.hurricane.coupon.dao.CouponMapper;
import com.hurricane.coupon.service.CouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService{

    @Autowired
    CouponMapper couponMapper;

    public MessengerVo getCouponInfo(MessengerVo messenger) {
        return null;
    }

    public MessengerVo getCouponList(MessengerVo messenger) {
        return null;
    }

    public MessengerVo saveCoupon(MessengerVo messenger) {
        return null;
    }

    public MessengerVo saveCouponBatch(MessengerVo messenger) {
        return null;
    }

    public MessengerVo editCoupon(MessengerVo messenger) {
        return null;
    }

    public MessengerVo deleteCoupon(MessengerVo messenger) {
        return null;
    }
}
