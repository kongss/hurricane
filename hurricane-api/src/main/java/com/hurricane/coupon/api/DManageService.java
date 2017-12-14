package com.hurricane.coupon.api;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface DManageService {

    MessengerVo getManageInfo(MessengerVo messenger);

    MessengerVo getManageList(MessengerVo messenger);

    MessengerVo saveManage(MessengerVo messenger);

    MessengerVo editManage(MessengerVo messenger);

    MessengerVo deleteManage(MessengerVo messenger);
}
