package com.hurricane;

import com.hurricane.coupon.api.DMenuService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuTest {
    static ClassPathXmlApplicationContext context;
    static DMenuService service;
    static {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext.xml");
        service = (DMenuService) context.getBean("dMenuService");
    }
}
