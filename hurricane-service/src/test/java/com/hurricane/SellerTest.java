package com.hurricane;

import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.api.DUserService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SellerTest {
    static ClassPathXmlApplicationContext context;
    static DSellerService service;
    static {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext.xml");
        service = (DSellerService) context.getBean("dSellerService");
    }

    public static void main(String[] args) {
        sellerList();
    }

    public static void addSeller(){

    }

    public static void sellerList(){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("limitStart","0");
        messenger.setInfo("limitSize","6");
        messenger.setInfo("sellerTypeUuid","1");


        service.getSellerSortList(messenger);
        //service.getSellerRecomList(messenger);

    }
}
