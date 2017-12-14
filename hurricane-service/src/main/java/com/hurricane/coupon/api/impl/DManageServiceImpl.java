package com.hurricane.coupon.api.impl;

import com.hurricane.coupon.api.DManageService;
import com.hurricane.coupon.service.ManageService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DManageServiceImpl implements DManageService{

    @Autowired
    ManageService manageService;

    public MessengerVo getManageInfo(MessengerVo messenger) {
        return manageService.getManageInfo(messenger);
    }

    public MessengerVo getManageList(MessengerVo messenger) {
        return manageService.getManageList(messenger);
    }

    public MessengerVo saveManage(MessengerVo messenger) {
        return manageService.saveManage(messenger);
    }

    public MessengerVo editManage(MessengerVo messenger) {
        return manageService.editManage(messenger);
    }

    public MessengerVo deleteManage(MessengerVo messenger) {
        return manageService.deleteManage(messenger);
    }
}
