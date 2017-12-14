package com.hurricane.coupon.manage;

import com.hurricane.coupon.api.DUserService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    DUserService dUserService;

    @RequestMapping("/couponList")
    @ResponseBody
    MessengerVo couponList(Map<String, Object> map){
        MessengerVo messenger = new MessengerVo();
        messenger = dUserService.getUserInfo(messenger);
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
