package com.hurricane.coupon.api;

import com.hurricane.coupon.utils.bean.MessengerVo;


public interface DUserService {

    MessengerVo getUserInfoByOpenId(MessengerVo messenger);

    MessengerVo getUserList(MessengerVo messenger);

    MessengerVo editUser(MessengerVo messenger);

    MessengerVo deleteUser(MessengerVo messenger);

    MessengerVo saveUser(MessengerVo messenger);
}
