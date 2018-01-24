package com.hurricane.coupon.web;

import com.hurricane.coupon.api.DUserService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    DUserService dUserService;

    @RequestMapping("/toCenter")
    String toCenter(){
        return "center/center" ;
    }
    @ResponseBody
    @RequestMapping(value = "/user/userInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo sellerInfo(@RequestParam(required = true) Integer openId){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("openId",openId);
        messenger = dUserService.getUserInfoByOpenId(messenger);
        return messenger;
    }
}
