package com.hurricane.coupon.api.impl;

import com.hurricane.coupon.api.DUserService;
import com.hurricane.coupon.service.UserService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;

public class DUserServiceImpl implements DUserService {

    @Autowired
    UserService userService;

    public MessengerVo getUserInfoByOpenId(MessengerVo messenger) {
        return userService.getUserInfoByOpenId(messenger);
    }

    public MessengerVo getUserList(MessengerVo messenger) {
        return userService.getUserList(messenger);
    }

    public MessengerVo editUser(MessengerVo messenger) {
        return null;
    }

    public MessengerVo deleteUser(MessengerVo messenger) {
        return null;
    }

    public MessengerVo saveUser(MessengerVo messenger) {
        return userService.saveUser(messenger);
    }

}
