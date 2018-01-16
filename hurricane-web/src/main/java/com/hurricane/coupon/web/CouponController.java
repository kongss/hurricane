package com.hurricane.coupon.web;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.hurricane.coupon.api.DCouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CouponController {

    @Autowired
    DCouponService dCouponService;

    /**
     * 首页推荐优惠券列表
     * @param limitStart
     * @param limitSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/coupon/couponRecomList", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo couponRecomList(@RequestParam(defaultValue = "0") Integer limitStart, @RequestParam (defaultValue = "20") Integer limitSize){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("limitStart", limitStart);
        messenger.setInfo("limitSize",limitSize);
        messenger = dCouponService.getCouponRecomList(messenger);
        return messenger;
    }
    @ResponseBody
    @RequestMapping(value = "/coupon/couponList", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo couponList(@RequestParam(defaultValue = "1") String currentPage, @RequestParam (defaultValue = "20") String pageSize){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("currentPage", currentPage);
        messenger.setInfo("pageSize",pageSize);
        messenger = dCouponService.getCouponList(messenger);
        return messenger;
    }

    @ResponseBody
    @RequestMapping(value = "/coupon/receiveRecordList", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo getReceiveRecordList(@RequestParam(required = true) String openid){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("openid",openid);
        messenger = dCouponService.getCouponReceiveRecordList(messenger);
        return messenger;
    }
    @ResponseBody
    @RequestMapping(value = "/coupon/takeCouponReceive", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo takeCouponReceive(@RequestParam(required = true) String openid){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("openid",openid);
        messenger = dCouponService.takeCouponReceive(messenger);
        return messenger;
    }
}
