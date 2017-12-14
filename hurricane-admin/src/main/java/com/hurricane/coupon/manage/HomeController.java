package com.hurricane.coupon.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String init(){
        return "pages/layout/init";
    }

    @RequestMapping("/home")
    public String home(){
        return "pages/home/home";
    }
    @RequestMapping("/couponList")
    public String couponList(){
        return "pages/coupon/couponList";
    }

    @RequestMapping("/sellerList")
    public String sellerList(){
        return "pages/seller/sellerList";
    }

    @RequestMapping("/userList")
    public String Home(){
        return "pages/user/userList";
    }
}
