package com.hurricane.coupon.service.impl;

import com.hurricane.coupon.dao.SellerMapper;
import com.hurricane.coupon.entity.Seller;
import com.hurricane.coupon.service.SellerService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import com.hurricane.coupon.utils.utils.HuUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerMapper sellerMapper;

    public MessengerVo getSellerInfo(MessengerVo messenger) {
        return null;
    }

    public MessengerVo getSellerList(MessengerVo messenger) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> sellerList = sellerMapper.selectSellerList(map);
        messenger = new MessengerVo();
        messenger.setResCode(HConstants.SUCCESS);
        messenger.setResDesc("查询成功");
        messenger.setInfo("sellerList",sellerList);
        return messenger;
    }

    public MessengerVo saveSeller(MessengerVo messenger) {
        System.out.println("messenger="+messenger);
        String name = messenger.getString("name");
        String longUrl = messenger.getString("longUrl");
        String logoPicUrl = messenger.getString("logoPicUrl");
        String siteUrl = messenger.getString("siteUrl");
        String source = messenger.getString("source");
        String status = messenger.getString("status");
        String shortUrl = messenger.getString("shortUrl");
        Seller seller = new Seller();
        seller.setUuid(HuUUID.getUuid());
        seller.setName(name);
        seller.setLongUrl(longUrl);
        seller.setLogoPicUrl(logoPicUrl);
        seller.setSiteUrl(siteUrl);
        seller.setSource(source);
        seller.setStatus(status);
        seller.setShortUrl(shortUrl);
        seller.setCreateTime(new Date());
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
