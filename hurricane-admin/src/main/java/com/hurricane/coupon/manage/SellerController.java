package com.hurricane.coupon.manage;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/admin/seller")
public class SellerController {

    @Autowired
    DSellerService dSellerService;

    @Value("${endpoint}")
    String endpoint;

    @Value("${accessKeyId}")
    String accessKeyId;

    @Value("${accessKeySecret}")
    String accessKeySecret;

    @Value("${bucketName}")
    String bucketName;

    @Value("${key}")
    String key;//初始为空值，存储时的文件名称

    @RequestMapping("/sellerList")
    void sellerList(Map<String, Object> map){

    }

    @RequestMapping("/addSeller")
    void addSeller(Map<String, Object> map){

    }

    @RequestMapping("/deleteSeller")
    void deleteSeller(Map<String, Object> map){

    }

    @RequestMapping("/editSeller")
    void editSeller(Map<String, Object> map){

    }

    @RequestMapping("/uploadLogo")
    @ResponseBody
    MessengerVo uploadLogo(@RequestParam("file") MultipartFile file)throws Exception{
        MessengerVo vo = new MessengerVo();
        vo.setResCode(HConstants.SUCCESS);
        vo.setResDesc("上传上传LOGO成功");
        InputStream stream = file.getInputStream();
        String fileName = file.getOriginalFilename();
        System.out.println("fileName>>>>>>>>>>>>>>>>>>>>>>>>>>>"+fileName);
        key = System.currentTimeMillis()+fileName;
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        PutObjectResult res = ossClient.putObject(bucketName, key, stream);
        System.out.println("res>>>>>>>>>>>>>>>>>>>>>>>>>>>"+res.getETag());
        // 设置URL过期时间为1小时
        Thread.sleep(300);
        //Date expiration = DateUtil.parseRfc822Date("Wed, 18 Mar 2018 14:20:00 GMT");
        Date expiration = new Date(new Date().getTime() + 10000);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        vo.setInfo("url",url);
        System.out.println(vo);
        // 关闭client
        ossClient.shutdown();

        return vo;
    }

    public static void main(String[] args) {

    }
}
