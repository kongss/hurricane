package com.hurricane.coupon.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String init(Map<String, Object> map){
        System.out.println(map);
        return "/pages/home/home";
    }

    @RequestMapping("/userList")
    public String Home(Map<String, Object> map){
        System.out.println("thymeleaf-start..........");
        map.put("hello","Hello Thymeleaf !");
        map.put("Thy","Hello Thymeleaf !");
        System.out.println(map);
        return "/pages/user/list";
    }
}
