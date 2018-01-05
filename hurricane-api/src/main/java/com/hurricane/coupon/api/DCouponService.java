package com.hurricane.coupon.api;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface DCouponService {

    MessengerVo getCoupon(MessengerVo messenger);

    MessengerVo getCouponInfoList(MessengerVo messenger);

    MessengerVo getCouponList(MessengerVo messenger);

    MessengerVo updateOverdueCoupon(MessengerVo messenger);

    MessengerVo saveCoupon(MessengerVo messenger);

    MessengerVo saveCouponBatch(MessengerVo messenger);

    MessengerVo editCoupon(MessengerVo messenger);

    MessengerVo deleteCoupon(MessengerVo messenger);
}
