package com.hurricane.note.api;

import com.hurricane.note.utils.bean.MessengerVo;


public interface DUserService {
    MessengerVo getUserInfo(MessengerVo params);
}