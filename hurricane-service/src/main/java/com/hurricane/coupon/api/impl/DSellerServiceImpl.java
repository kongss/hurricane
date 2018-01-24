package com.hurricane.coupon.api.impl;

import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.service.SellerService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;

public class DSellerServiceImpl implements DSellerService {

    @Autowired
    SellerService sellerService;

    public MessengerVo getSellerTypeList(MessengerVo messenger) {
        return sellerService.getSellerTypeList(messenger);
    }

    public MessengerVo getSellerRecomList(MessengerVo messenger) {
        return sellerService.getSellerRecomList(messenger);
    }

    public MessengerVo getSellerInfo(MessengerVo messenger) {
        return sellerService.getSellerInfo(messenger);
    }

    public MessengerVo getSellerList(MessengerVo messenger) {
        return sellerService.getSellerList(messenger);
    }

    public MessengerVo getSellerSortList(MessengerVo messenger) {
        return sellerService.getSellerSortList(messenger);
    }

    public MessengerVo saveSeller(MessengerVo messenger) {
        return sellerService.saveSeller(messenger);
    }

    public MessengerVo saveSellerBatch(MessengerVo messenger) {
        return null;
    }

    public MessengerVo editSeller(MessengerVo messenger) {
        return sellerService.editSeller(messenger);
    }

    public MessengerVo deleteSeller(MessengerVo messenger) {
        return sellerService.deleteSeller(messenger);
    }
}
