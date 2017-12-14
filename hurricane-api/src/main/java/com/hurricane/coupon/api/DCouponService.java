package com.hurricane.coupon.api;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface DCouponService {

    MessengerVo getCouponInfo(MessengerVo messenger);

    MessengerVo getCouponList(MessengerVo messenger);

    MessengerVo saveCoupon(MessengerVo messenger);

    MessengerVo saveCouponBatch(MessengerVo messenger);

    MessengerVo editCoupon(MessengerVo messenger);

    MessengerVo deleteCoupon(MessengerVo messenger);
}
