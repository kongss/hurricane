package com.hurricane;

import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.api.DUserService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    static ClassPathXmlApplicationContext context;
    static DSellerService service;
    static {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext.xml");
        service = (DSellerService) context.getBean("sellerService");
    }

    public static void main(String[] args) {
        MessengerVo vo = new MessengerVo();

        //System.out.printf("user==="+userInfo.getString("ttttt"));
    }
}
