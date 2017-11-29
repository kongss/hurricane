package com.hurricane.note.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Value("${name}")
    String sp;

    @RequestMapping("/")
    @ResponseBody String home(){
        return "Hello "+sp ;
    }
}
