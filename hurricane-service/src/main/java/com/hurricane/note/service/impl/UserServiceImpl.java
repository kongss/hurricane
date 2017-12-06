package com.hurricane.note.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
        logger.info("UserServiceImpl-saveUser-messenger:"+messenger);
        JSONObject obj = JSON.parseObject(messenger.getString("userInfo"));
        User user = new User();
        user.setUuid(HuUUID.getUuid());
        user.setNickname(obj.getString("nickname"));
        user.setCity(obj.getString("city"));
        user.setGender(obj.getString("gender"));
        user.setProvince(obj.getString("province"));
        user.setYear(obj.getString("year"));
        user.setFigureurl(obj.getString("figureurl"));
        user.setFigureurl1(obj.getString("figureurl_1"));
        user.setFigureurl2(obj.getString("figureurl_2"));
        user.setFigureurlQq1(obj.getString("figureurl_qq_1"));
        user.setFigureurlQq2(obj.getString("figureurl_qq_2"));
        user.setOpenid(obj.getString("openId"));
        int i = userMapper.insertSelective(user);
        logger.info("UserServiceImpl-saveUser-保存数据:"+i);
        if (i>0){
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("保存成功");
        }else {
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("保存失败");
        }
        return messenger;
    }

    public static void main(String[] args) {

    }
}
