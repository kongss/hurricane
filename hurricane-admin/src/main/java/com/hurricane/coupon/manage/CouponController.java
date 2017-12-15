package com.hurricane.coupon.manage;

import com.hurricane.coupon.api.DCouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin/coupon")
public class CouponController {

    @Autowired
    DCouponService dCouponService;

    @RequestMapping("/couponList")
    @ResponseBody
    MessengerVo couponList(HttpServletRequest request){
        String currentPage = request.getParameter("currentPage");//当前页
        if (StringUtils.isEmpty(currentPage)){
            currentPage = "1";
        }
        String pageSize = request.getParameter("pageSize");//每页条数
        if (StringUtils.isEmpty(pageSize)){
            pageSize = "10";
        }
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("currentPage", currentPage);
        messenger.setInfo("pageSize",pageSize);

        System.out.println("CouponController-前"+messenger);
        messenger = dCouponService.getCouponList(messenger);
        System.out.println("CouponController-后"+messenger);
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
