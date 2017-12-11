package com.hurricane.coupon.manage;

import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    DSellerService dSellerService;

    @RequestMapping("/")
    public String init(Map<String, Object> map){
        return "pages/layout/init";
    }

    @RequestMapping("/home")
    public String home(Map<String, Object> map){
        map.put("user","kong");
        map.put("pwd","123");
        return "pages/home/home";
    }
    @RequestMapping("/couponList")
    public String couponList(Map<String, Object> map){
        map.put("user","kong");
        map.put("pwd","123");
        return "pages/coupon/couponList";
    }

    @RequestMapping("/sellerList")
    public String sellerList(Map<String, Object> map){
        map.put("user","kong");
        map.put("pwd","123");
        return "pages/seller/sellerList";
    }

    @RequestMapping("/addSeller")
    @ResponseBody
    public MessengerVo addSeller(String name, String longUrl, String logoPicUrl, String siteUrl, String source, String status, String shortUrl){
        System.out.println("保存"+name+" "+longUrl+" "+logoPicUrl+" "+siteUrl+" "+source+" "+status+" "+shortUrl);
        if (StringUtils.isEmpty(name)){}
        if (StringUtils.isEmpty(longUrl)){}
        if (StringUtils.isEmpty(logoPicUrl)){}
        if (StringUtils.isEmpty(siteUrl)){}
        if (StringUtils.isEmpty(source)){}
        if (StringUtils.isEmpty(status)){}
        if (StringUtils.isEmpty(shortUrl)){}

        MessengerVo messenger = new MessengerVo();
        MessengerVo vo = dSellerService.saveSeller(messenger);

        if ("0000" != vo.getResCode()){
            messenger.setResCode(HConstants.ERROR);
            messenger.setResDesc("保存失败");

        }
        messenger.setResCode(HConstants.SUCCESS);
        messenger.setResDesc("保存成功");
        return messenger;
    }

    @RequestMapping("/userList")
    public String Home(Map<String, Object> map){
        System.out.println("thymeleaf-start..........");
        map.put("hello","Hello freemarker !");
        map.put("Thy","Hello freemarker !");
        System.out.println(map);
        return "pages/user/list";
    }
}
