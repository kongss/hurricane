package com.hurricane.coupon.service;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface CouponService {

    MessengerVo takeCouponReceive(MessengerVo messenger);

    MessengerVo getCouponReceiveRecordList(MessengerVo messenger);

    MessengerVo getCoupon(MessengerVo messenger);

    MessengerVo getCouponInfoList(MessengerVo messenger);

    MessengerVo getCouponList(MessengerVo messenger);

    MessengerVo getCouponRecomList(MessengerVo messenger);

    MessengerVo updateOverdueCoupon(MessengerVo messenger);

    MessengerVo saveCoupon(MessengerVo messenger);

    MessengerVo saveCouponBatch(MessengerVo messenger);

    MessengerVo editCoupon(MessengerVo messenger);

    MessengerVo deleteCoupon(MessengerVo messenger);
}
