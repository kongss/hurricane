package com.hurricane.note.service;

import com.hurricane.note.utils.bean.MessengerVo;

public interface UserService {

    MessengerVo getUserInfo(MessengerVo messenger);

    MessengerVo saveUser(MessengerVo messenger);
}
