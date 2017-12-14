package com.hurricane.coupon.manage;

import com.hurricane.coupon.api.DCouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/admin/coupon")
public class CouponController {

    @Autowired
    DCouponService dCouponService;

    @RequestMapping("/couponList")
    @ResponseBody
    MessengerVo couponList(Map<String, Object> map){
        MessengerVo messenger = new MessengerVo();
        dCouponService.getCouponList(messenger);
        return messenger;
    }
    @RequestMapping("/addCoupon")
    @ResponseBody
    MessengerVo addCoupon(Map<String, Object> map){
        MessengerVo messenger = new MessengerVo();

        return messenger;
    }
    @RequestMapping("/deleteCoupon")
    @ResponseBody
    MessengerVo deleteCoupon(Map<String, Object> map){
        MessengerVo messenger = new MessengerVo();

        return messenger;
    }

    @RequestMapping("/editCoupon")
    @ResponseBody
    MessengerVo editCoupon(Map<String, Object> map){
        MessengerVo messenger = new MessengerVo();

        return messenger;
    }
}
