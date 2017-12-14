package com.hurricane.coupon.api.impl;

import com.hurricane.coupon.api.DMenuService;
import com.hurricane.coupon.service.MenuService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DMenuServiceImpl implements DMenuService{

    @Autowired
    MenuService menuService;

    public MessengerVo getMenuInfo(MessengerVo messenger) {
        return menuService.getMenuInfo(messenger);
    }

    public MessengerVo getMenuList(MessengerVo messenger) {
        return menuService.getMenuList(messenger);
    }

    public MessengerVo saveMenu(MessengerVo messenger) {
        return menuService.saveMenu(messenger);
    }

    public MessengerVo editMenu(MessengerVo messenger) {
        return menuService.editMenu(messenger);
    }

    public MessengerVo deleteMenu(MessengerVo messenger) {
        return menuService.deleteMenu(messenger);
    }
}
