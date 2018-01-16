package com.hurricane.coupon.api;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface DSellerService {

    MessengerVo getSellerRecomList(MessengerVo messenger);

    MessengerVo getSellerInfo(MessengerVo messenger);

    MessengerVo getSellerList(MessengerVo messenger);

    MessengerVo getSellerSortList(MessengerVo messenger);

    MessengerVo saveSeller(MessengerVo messenger);

    MessengerVo saveSellerBatch(MessengerVo messenger);

    MessengerVo editSeller(MessengerVo messenger);

    MessengerVo deleteSeller(MessengerVo messenger);

}
