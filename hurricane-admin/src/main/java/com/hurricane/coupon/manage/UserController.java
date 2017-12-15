package com.hurricane.coupon.manage;

import com.hurricane.coupon.api.DUserService;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    DUserService dUserService;

    @RequestMapping("/userList")
    @ResponseBody
    MessengerVo userList(HttpServletRequest request){
        String currentPage = request.getParameter("currentPage");//当前页
        if (StringUtils.isEmpty(currentPage)){
            currentPage = "1";
        }
        String pageSize = request.getParameter("pageSize");//每页条数
        if (StringUtils.isEmpty(pageSize)){
            pageSize = "10";
        }
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("currentPage", currentPage);
        messenger.setInfo("pageSize",pageSize);
        System.out.println("UserController-前"+messenger);
        messenger = dUserService.getUserList(messenger);
        System.out.println("UserController-后"+messenger);
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
