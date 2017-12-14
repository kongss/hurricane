package com.hurricane.coupon.service.impl;

import com.hurricane.coupon.dao.ManageMapper;
import com.hurricane.coupon.service.ManageService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManageServiceImpl implements ManageService{

    @Autowired
    ManageMapper manageMapper;

    public MessengerVo getManageInfo(MessengerVo messenger) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> manage = manageMapper.selectManage(map);
        messenger = new MessengerVo();
        messenger.setResCode(HConstants.SUCCESS);
        messenger.setInfo("manage",manage);
        return messenger;
    }

    public MessengerVo getManageList(MessengerVo messenger) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> manageList = manageMapper.selectManageList(map);
        messenger = new MessengerVo();
        messenger.setResCode(HConstants.SUCCESS);
        messenger.setResDesc("查询管理员信息列表成功");
        messenger.setInfo("manageList",manageList);
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
