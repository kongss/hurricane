package com.hurricane.note.service.impl;

import com.hurricane.note.dao.UserMapper;
import com.hurricane.note.entity.User;
import com.hurricane.note.service.UserService;
import com.hurricane.note.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    public MessengerVo getUserInfo(MessengerVo params) {
        User user = userMapper.selectByPrimaryKey("14d7d3b2-c2ac-44c4-859f-5e858efa0223");
        params.setInfo("ttttt",user.getNickname());
        return params;
    }
}
