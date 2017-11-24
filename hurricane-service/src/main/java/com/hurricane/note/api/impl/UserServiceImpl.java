package com.hurricane.note.api.impl;

import com.hurricane.note.api.UserService;
import com.hurricane.note.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserService userService;

    public MessengerVo getUserInfo(MessengerVo messenger) {
        return userService.getUserInfo(messenger);
    }
}
