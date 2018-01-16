package com.hurricane.coupon.web;

import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SellerController {

    @Autowired
    DSellerService dSellerService;

    @ResponseBody
    @RequestMapping(value = "/seller/sellerList", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo sellerList(@RequestParam (defaultValue = "0") Integer limitStart, @RequestParam (defaultValue = "20") Integer limitSize, @RequestParam(required = true) Integer sellerTypeUuid){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("limitStart", limitStart);
        messenger.setInfo("limitSize",limitSize);
        messenger.setInfo("sellerTypeUuid",sellerTypeUuid);
        messenger = dSellerService.getSellerSortList(messenger);
        return messenger;
    }
}
