package com.hurricane.coupon.service.impl;

import com.hurricane.coupon.dao.ManageMapper;
import com.hurricane.coupon.service.ManageService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManageServiceImpl implements ManageService{

    Logger logger = LogManager.getLogger(ManageServiceImpl.class);

    @Autowired
    ManageMapper manageMapper;

    public MessengerVo getManageInfo(MessengerVo messenger) {
        try {
            logger.info("ManageServiceImpl-getManageInfo-param ",messenger);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("username",messenger.getString("username"));
            map.put("password",messenger.getString("password"));
            Map<String, Object> manage = manageMapper.selectManage(map);
            messenger = new MessengerVo();
            messenger.setInfo("manage", manage);
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Query Success");
        } catch (Exception e) {
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.error("ManageServiceImpl-getManageInfo-error ",e);
        }
        logger.info("ManageServiceImpl-getManageInfo-result ",messenger);
        return messenger;
    }

    public MessengerVo getManageList(MessengerVo messenger) {
        try {
            logger.info("ManageServiceImpl-getManageList-param ",messenger);
            HashMap<String, Object> map = new HashMap<String, Object>();
            List<Map<String, Object>> manageList = manageMapper.selectManageList(map);
            messenger = new MessengerVo();
            messenger.setInfo("manageList",manageList);
            messenger.setResCode(HConstants.SUCCESS);
            messenger.setResDesc("Query Success");
        } catch (Exception e) {
            messenger = new MessengerVo();
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("Query Error");
            logger.error("ManageServiceImpl-getManageList-error ",e);
        }
        logger.info("ManageServiceImpl-getManageList-result ",messenger);
        return messenger;
    }

    public MessengerVo saveManage(MessengerVo messenger) {
        return null;
    }

    public MessengerVo editManage(MessengerVo messenger) {
        return null;
    }

    public MessengerVo deleteManage(MessengerVo messenger) {
        return null;
    }
}
