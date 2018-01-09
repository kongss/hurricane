package com.hurricane.coupon.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hurricane.coupon.dao.UserMapper;
import com.hurricane.coupon.entity.User;
import com.hurricane.coupon.service.UserService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;

import com.hurricane.coupon.utils.page.Pager;
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
    public MessengerVo getUserInfoByOpenId(MessengerVo messenger) {
        try{
            logger.info("SellerServiceImpl-getUserInfoByOpenId-param "+messenger);
            String openId = messenger.getString("openId");
            Map<String, Object> user = userMapper.getUserInfoByOpenId(openId);
            messenger.clear();
            messenger.setInfo("user",user);
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Query Success");
        }catch (Exception e){
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.error("SellerServiceImpl-getUserInfoByOpenId-error "+e);
        }
        logger.info("SellerServiceImpl-getUserInfoByOpenId-result "+messenger);
        return messenger;
    }

    /**
     * 新增用户信息
     * @param messenger
     * @return
     */
    public MessengerVo saveUser(MessengerVo messenger) {
        try {
            logger.info("UserServiceImpl-saveUser-param "+messenger);
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
            logger.info("save:param{user} "+user);
            int i = userMapper.insertSelective(user);
            logger.info("save:result{num} "+i);
            messenger.clear();
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Save Success");
        }catch (Exception e){
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Save Error");
            logger.error("UserServiceImpl-saveUser-error "+e);
        }
        logger.info("UserServiceImpl-saveUser-result "+messenger);
        return messenger;
    }

    public MessengerVo getUserList(MessengerVo messenger) {
        try{
            logger.info("SellerServiceImpl-getUserList-param "+messenger);
            int currentPage = Integer.parseInt(messenger.getString("currentPage"));//当前页
            int pageSize = Integer.parseInt(messenger.getString("pageSize"));//每页条数

            HashMap<String, Object> map = new HashMap<String, Object>();
            //查询总条数
            int total = userMapper.selectUserTotal(map);
            //构造方法计算分页参数
            Pager pager = new Pager(currentPage, pageSize, total);

            map.put("limitStart",(currentPage-1) * pageSize);
            map.put("limitSize",pageSize);
            List<Map<String, Object>> list = userMapper.selectUserList(map);
            messenger.clear();
            messenger.setInfo("list",list);
            messenger.setInfo("pageTotal",pager.getPageTotal());
            messenger.setInfo("currentPage",pager.getCurrentPage());
            messenger.setInfo("firstPage",pager.getFirstPage());
            messenger.setInfo("lastPage",pager.getLastPage());
            messenger.setInfo("nextPage",pager.getNextPage());
            messenger.setInfo("pageSize",pager.getPageSize());
            messenger.setInfo("previousPage",pager.getPreviousPage());
            messenger.setInfo("recordTotal",pager.getRecordTotal());
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Query Success");
        }catch (Exception e){
            messenger.clear();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.error("SellerServiceImpl-getUserList-error "+e);
        }
        logger.info("SellerServiceImpl-getUserList-result "+messenger);
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
