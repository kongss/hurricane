package com.hurricane.coupon.api.impl;

import com.hurricane.coupon.api.DCouponService;
import com.hurricane.coupon.service.CouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;

public class DCouponServiceImpl implements DCouponService{

    @Autowired
    CouponService couponService;

    public MessengerVo getCoupon(MessengerVo messenger) {
        return couponService.getCoupon(messenger);
    }

    public MessengerVo getCouponInfoList(MessengerVo messenger) {
        return couponService.getCouponInfoList(messenger);
    }

    public MessengerVo getCouponList(MessengerVo messenger) {
        return couponService.getCouponList(messenger);
    }

    public MessengerVo getCouponSortList(MessengerVo messenger) {
        return couponService.getCouponSortList(messenger);
    }

    public MessengerVo getCouponRecomList(MessengerVo messenger) {
        return couponService.getCouponRecomList(messenger);
    }

    public MessengerVo updateOverdueCoupon(MessengerVo messenger) {
        return couponService.updateOverdueCoupon(messenger);
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
