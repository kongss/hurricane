package com.hurricane;

import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.api.DUserService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    static ClassPathXmlApplicationContext context;
    static DUserService service;
    static {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext.xml");
        service = (DUserService) context.getBean("dUserService");
    }

    public static void main(String[] args) {
        MessengerVo vo = new MessengerVo();
        MessengerVo userList = service.getUserList(vo);
        System.out.println(userList);
    }
}
