package com.hurricane;

import com.hurricane.coupon.api.DCouponService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CouponTest {
    static ClassPathXmlApplicationContext context;
    static DCouponService service;
    static {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext.xml");
        service = (DCouponService) context.getBean("dCouponService");
    }

    public static void main(String[] args) {
        MessengerVo vo = new MessengerVo();
        vo.setInfo("currentPage","1");
        vo.setInfo("pageSize","10");
        vo.setInfo("sellerSource","2");
        vo.setInfo("couponType","2");
        vo.setInfo("sellerName","网易严选");

        service.getCouponList(vo);
    }

}
