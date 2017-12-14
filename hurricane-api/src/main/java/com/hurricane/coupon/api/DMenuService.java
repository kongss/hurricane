package com.hurricane.coupon.api;

import com.hurricane.coupon.utils.bean.MessengerVo;

public interface DMenuService {

    MessengerVo getMenuInfo(MessengerVo messenger);

    MessengerVo getMenuList(MessengerVo messenger);

    MessengerVo saveMenu(MessengerVo messenger);

    MessengerVo editMenu(MessengerVo messenger);

    MessengerVo deleteMenu(MessengerVo messenger);
}
