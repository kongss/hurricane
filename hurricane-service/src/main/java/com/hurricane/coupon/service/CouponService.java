package com.hurricane.coupon.service;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface CouponService {

    MessengerVo getCouponInfo(MessengerVo messenger);

    MessengerVo getCouponList(MessengerVo messenger);

    MessengerVo saveCoupon(MessengerVo messenger);

    MessengerVo saveCouponBatch(MessengerVo messenger);

    MessengerVo editCoupon(MessengerVo messenger);

    MessengerVo deleteCoupon(MessengerVo messenger);
}
