package com.hurricane.coupon.service;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface UserService {

    MessengerVo getUserInfo(MessengerVo messenger);

    MessengerVo saveUser(MessengerVo messenger);
}
