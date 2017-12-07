package com.hurricane.coupon.api;

import com.hurricane.coupon.utils.bean.MessengerVo;


public interface DUserService {
    MessengerVo getUserInfo(MessengerVo messenger);

    MessengerVo saveUser(MessengerVo messenger);
}
