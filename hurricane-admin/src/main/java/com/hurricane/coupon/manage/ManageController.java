package com.hurricane.coupon.manage;

import com.hurricane.coupon.api.DManageService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/manage")
public class ManageController {

    @Autowired
    DManageService dManageService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "pages/manage/login";
    }

    @RequestMapping("/login")
    public String login(String username, String password){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("username",username);
        messenger.setInfo("password",password);
        messenger = dManageService.getManageInfo(messenger);

        return "redirect:/";
    }

}
