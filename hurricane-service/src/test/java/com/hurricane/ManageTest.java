package com.hurricane;

import com.hurricane.coupon.api.DManageService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManageTest {
    static ClassPathXmlApplicationContext context;
    static DManageService service;
    static {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext.xml");
        service = (DManageService) context.getBean("dManageService");
    }

    public static void main(String[] args) {
        MessengerVo vo = new MessengerVo();
        MessengerVo manageList = service.getManageList(vo);
        System.out.println(manageList);
    }
}
