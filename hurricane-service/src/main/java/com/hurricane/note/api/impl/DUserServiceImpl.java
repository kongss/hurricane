package com.hurricane.note.api.impl;

import com.hurricane.note.api.DUserService;
import com.hurricane.note.service.UserService;
import com.hurricane.note.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DUserServiceImpl implements DUserService {

    @Autowired
    UserService userService;

    public MessengerVo getUserInfo(MessengerVo messenger) {
        return userService.getUserInfo(messenger);
    }

    public MessengerVo saveUser(MessengerVo messenger) {
        return userService.saveUser(messenger);
    }
}
