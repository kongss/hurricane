package com.hurricane.coupon.service;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface ManageService {

    MessengerVo getManageInfo(MessengerVo messenger);

    MessengerVo getManageList(MessengerVo messenger);

    MessengerVo saveManage(MessengerVo messenger);

    MessengerVo editManage(MessengerVo messenger);

    MessengerVo deleteManage(MessengerVo messenger);
}
