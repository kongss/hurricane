package com.hurricane.coupon.api.impl;

import com.hurricane.coupon.api.DCouponService;
import com.hurricane.coupon.service.CouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DCouponServiceImpl implements DCouponService{

    @Autowired
    CouponService couponService;

    public MessengerVo getCouponInfo(MessengerVo messenger) {
        return couponService.getCouponInfo(messenger);
    }

    public MessengerVo getCouponList(MessengerVo messenger) {
        return couponService.getCouponList(messenger);
    }

    public MessengerVo saveCoupon(MessengerVo messenger) {
        return couponService.saveCoupon(messenger);
    }

    public MessengerVo saveCouponBatch(MessengerVo messenger) {
        return couponService.saveCouponBatch(messenger);
    }

    public MessengerVo editCoupon(MessengerVo messenger) {
        return couponService.editCoupon(messenger);
    }

    public MessengerVo deleteCoupon(MessengerVo messenger) {
        return couponService.deleteCoupon(messenger);
    }
}
