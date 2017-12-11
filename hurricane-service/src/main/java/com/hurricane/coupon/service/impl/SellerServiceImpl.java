package com.hurricane.coupon.service.impl;

import com.hurricane.coupon.dao.SellerMapper;
import com.hurricane.coupon.entity.Seller;
import com.hurricane.coupon.service.SellerService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import com.hurricane.coupon.utils.utils.HuUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerMapper sellerMapper;

    public MessengerVo getSellerInfo(MessengerVo messenger) {
        return null;
    }

    public MessengerVo getSellerList(MessengerVo messenger) {
        return null;
    }

    public MessengerVo saveSeller(MessengerVo messenger) {

        System.out.println("messenger="+messenger);
        String sellerInfo = messenger.getString("sellerInfo");
        Seller seller = new Seller();
        seller.setUuid(HuUUID.getUuid());
        int i = sellerMapper.insertSelective(seller);
        if (i>0){
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("保存商城成功");
        }else {
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("保存商城失败");
        }
        return messenger;
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
