package com.hurricane.note.web;

import com.hurricane.note.api.DUserService;
import com.hurricane.note.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Value("${name}")
    String sp;

    @Autowired
    DUserService dUserService;

    @RequestMapping("/")
    @ResponseBody String home(){
        MessengerVo vo = new MessengerVo();
        MessengerVo info = dUserService.getUserInfo(vo);
        info.getString("ttttt");
        return "Hello "+sp ;
    }
}
