package com.hurricane;

import com.hurricane.note.api.DUserService;
import com.hurricane.note.utils.bean.MessengerVo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    static ClassPathXmlApplicationContext context;
    static DUserService service;
    static {
        context = new ClassPathXmlApplicationContext("classpath*:/spring/applicationContext.xml");
        service = (DUserService) context.getBean("userService");
    }

    public static void main(String[] args) {
        MessengerVo vo = new MessengerVo();
        MessengerVo userInfo = service.getUserInfo(vo);
        System.out.printf("user==="+userInfo.getString("ttttt"));
    }
}
