package com.hurricane.coupon.api.impl;

import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.service.SellerService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DSellerServiceImpl implements DSellerService {

    @Autowired
    SellerService sellerService;

    public MessengerVo getSellerInfo(MessengerVo messenger) {
        return null;
    }

    public MessengerVo getSellerList(MessengerVo messenger) {
        return sellerService.getSellerList(messenger);
    }

    public MessengerVo saveSeller(MessengerVo messenger) {
        return sellerService.saveSeller(messenger);
    }

    public MessengerVo saveSellerBatch(MessengerVo messenger) {
        return null;
    }

    public MessengerVo editSeller(MessengerVo messenger) {
        return null;
    }

    public MessengerVo deleteSeller(MessengerVo messenger) {
        return null;
    }
}
