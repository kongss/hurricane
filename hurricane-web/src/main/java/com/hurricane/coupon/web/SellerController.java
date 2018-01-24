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

    /**
     * 跳转商城列表页
     * @return
     */
    @RequestMapping("/toSeller")
    String toSeller(){
        return "seller/sellerList" ;
    }
    /**
     * 跳转商城详情页
     * @return
     */
    @RequestMapping("/toSellerDetails")
    String toSellerDetails(){
        return "seller/sellerDetails" ;
    }
    /**
     * 首页分类商城列表，商城大全 同一个接口，数据内容相同，展示样式不同
     * @param limitStart
     * @param limitSize
     * @param sellerTypeUuid
     * @return
     */
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

    /**
     * 商城推荐列表接口
     * @param limitStart
     * @param limitSize
     * @param sellerTypeUuid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/seller/sellerRecomList", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo sellerRecomList(@RequestParam (defaultValue = "0") Integer limitStart, @RequestParam (defaultValue = "20") Integer limitSize){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("limitStart", limitStart);
        messenger.setInfo("limitSize",limitSize);
        messenger = dSellerService.getSellerRecomList(messenger);
        return messenger;
    }
    @ResponseBody
    @RequestMapping(value = "/seller/sellerInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public MessengerVo sellerInfo(@RequestParam(required = true) String uuid){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("uuid",uuid);
        messenger = dSellerService.getSellerInfo(messenger);
        return messenger;
    }
}
