package com.hurricane.coupon.service.impl;

import com.hurricane.coupon.dao.CouponMapper;
import com.hurricane.coupon.service.CouponService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CouponServiceImpl implements CouponService{

    @Autowired
    CouponMapper couponMapper;

    public MessengerVo getCouponInfo(MessengerVo messenger) {
        return null;
    }

    public MessengerVo getCouponList(MessengerVo messenger) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> couponList = couponMapper.selectCouponList(map);
        messenger = new MessengerVo();
        messenger.setResCode(HConstants.SUCCESS);
        messenger.setResDesc("查询优惠券列表成功");
        messenger.setInfo("couponList",couponList);
        return messenger;
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
