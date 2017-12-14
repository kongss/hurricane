package com.hurricane.coupon.manage;

import com.hurricane.coupon.api.DUserService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    DUserService dUserService;

    @RequestMapping("/userList")
    @ResponseBody
    MessengerVo userList(Map<String, Object> map){
        MessengerVo messenger = new MessengerVo();
        messenger = dUserService.getUserList(messenger);
        return messenger;
    }
    @RequestMapping("/addUser")
    @ResponseBody
    MessengerVo addUser(Map<String, Object> map){
        MessengerVo messenger = new MessengerVo();

        return messenger;
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    MessengerVo deleteUser(Map<String, Object> map){
        MessengerVo messenger = new MessengerVo();

        return messenger;
    }

    @RequestMapping("/editUser")
    @ResponseBody
    MessengerVo editUser(Map<String, Object> map){
        MessengerVo messenger = new MessengerVo();

        return messenger;
    }
}
