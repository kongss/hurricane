package com.hurricane.coupon.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hurricane.coupon.dao.UserMapper;
import com.hurricane.coupon.entity.User;
import com.hurricane.coupon.service.UserService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;

import com.hurricane.coupon.utils.utils.HuUUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            messenger.setResDesc("保存用户成功");
        }else {
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("保存用户失败");
        }
        return messenger;
    }

    public MessengerVo getUserList(MessengerVo messenger) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> userList = userMapper.selectUserList(map);
        messenger = new MessengerVo();
        messenger.setResCode(HConstants.SUCCESS);
        messenger.setInfo("userList",userList);
        return messenger;
    }

    public MessengerVo editUser(MessengerVo messenger) {
        return null;
    }

    public MessengerVo deleteUser(MessengerVo messenger) {
        return null;
    }

    public static void main(String[] args) {

    }
}
