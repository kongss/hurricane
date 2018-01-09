package com.hurricane.coupon.service;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface UserService {

    MessengerVo getUserInfoByOpenId(MessengerVo messenger);

    MessengerVo saveUser(MessengerVo messenger);

    MessengerVo getUserList(MessengerVo messenger);

    MessengerVo editUser(MessengerVo messenger);

    MessengerVo deleteUser(MessengerVo messenger);
}
