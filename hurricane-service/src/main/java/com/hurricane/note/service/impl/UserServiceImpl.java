package com.hurricane.note.service.impl;

import com.hurricane.note.dao.UserMapper;
import com.hurricane.note.entity.User;
import com.hurricane.note.service.UserService;
import com.hurricane.note.utils.bean.HConstants;
import com.hurricane.note.utils.bean.MessengerVo;

import com.hurricane.note.utils.utils.HuUUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    /**
     * 查询用户信息
     * @param messenger
     * @return
     */
    public MessengerVo getUserInfo(MessengerVo messenger) {
        User user = userMapper.selectByPrimaryKey("14d7d3b2-c2ac-44c4-859f-5e858efa0223");
        logger.info("nickname:"+user.getNickname());
        messenger.setInfo("nickname",user.getNickname());
        return messenger;
    }

    /**
     * 新增用户信息
     * @param messenger
     * @return
     */
    public MessengerVo saveUser(MessengerVo messenger) {
        logger.info("UserServiceImpl-saveUser-messenger:",messenger);
        User user = new User();
        user.setUuid(HuUUID.getUuid());
        int i = userMapper.insertSelective(user);
        if (i>0){
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("保存成功");
        }else {
            messenger.setResCode(HConstants.ERROR);
        }
        return messenger;
    }
}
