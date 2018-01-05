package com.hurricane.coupon.web;

import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SellerController {

    @Autowired
    DSellerService dSellerService;

    @ResponseBody
    @RequestMapping(value = "/seller/sellerList", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo sellerList(){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("limitStart", "0");
        messenger.setInfo("limitSize","50");
        messenger = dSellerService.getSellerSortList(messenger);
        System.out.println(messenger);
        return messenger;
    }
}
