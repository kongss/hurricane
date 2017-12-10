package com.hurricane.coupon.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String init(Map<String, Object> map){
        return "pages/layout/init";
    }

    @RequestMapping("/home")
    public String home(Map<String, Object> map){
        map.put("user","kong");
        map.put("pwd","123");
        return "pages/home/home";
    }
    @RequestMapping("/couponList")
    public String couponList(Map<String, Object> map){
        map.put("user","kong");
        map.put("pwd","123");
        return "pages/coupon/couponList";
    }

    @RequestMapping("/userList")
    public String Home(Map<String, Object> map){
        System.out.println("thymeleaf-start..........");
        map.put("hello","Hello Thymeleaf !");
        map.put("Thy","Hello Thymeleaf !");
        System.out.println(map);
        return "pages/user/list";
    }
}
