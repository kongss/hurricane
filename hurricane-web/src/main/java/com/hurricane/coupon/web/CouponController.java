package com.hurricane.coupon.web;

import com.hurricane.coupon.api.DCouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CouponController {

    @Autowired
    DCouponService dCouponService;

    @ResponseBody
    @RequestMapping(value = "/coupon/couponRecomList", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo couponRecomList(@RequestParam(defaultValue = "0") Integer limitStart, @RequestParam (defaultValue = "20") Integer limitSize){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("limitStart", limitStart);
        messenger.setInfo("limitSize",limitSize);
        messenger = dCouponService.getCouponRecomList(messenger);
        return messenger;
    }
}
