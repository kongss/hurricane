package com.hurricane.coupon.manage;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.DateUtil;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.hurricane.coupon.api.DSellerService;
import com.hurricane.coupon.utils.bean.HConstants;
import com.hurricane.coupon.utils.bean.MessengerVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/sellerList", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    MessengerVo sellerList(HttpServletRequest request){
        String currentPage = request.getParameter("currentPage");//当前页
        if (StringUtils.isEmpty(currentPage)){
            currentPage = "1";
        }
        String pageSize = request.getParameter("pageSize");//每页条数
        if (StringUtils.isEmpty(pageSize)){
            pageSize = "10";
        }

        String source = request.getParameter("source");//来源
        String status = request.getParameter("status");//状态
        String sellerTypeUuid = request.getParameter("sellerTypeUuid");//商城类型
        String name = request.getParameter("name");//名称
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("currentPage", currentPage);
        messenger.setInfo("pageSize",pageSize);
        messenger.setInfo("source",source);
        messenger.setInfo("status",status);
        messenger.setInfo("sellerTypeUuid",sellerTypeUuid);
        messenger.setInfo("name",name);

        messenger = dSellerService.getSellerList(messenger);
        return messenger;
    }

    @RequestMapping("/getSeller")
    @ResponseBody
    MessengerVo getSeller(HttpServletRequest request,String uuid){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("uuid",uuid);
        messenger = dSellerService.getSellerInfo(messenger);
        return messenger;
    }

    @RequestMapping("/editSeller")
    @ResponseBody
    public MessengerVo editSeller(String uuid,String name, String longUrl, String logoPicUrl, String siteUrl, String source, String status, String shortUrl){
        MessengerVo messenger = new MessengerVo();
        System.out.println("修改 "+uuid+" "+name+" "+longUrl+" "+logoPicUrl+" "+siteUrl+" "+source+" "+status+" "+shortUrl);
        messenger.setInfo("uuid",uuid);
        messenger.setInfo("name",name);
        messenger.setInfo("longUrl",longUrl);
        messenger.setInfo("logoPicUrl",logoPicUrl);
        messenger.setInfo("siteUrl",siteUrl);
        messenger.setInfo("source",source);
        messenger.setInfo("status",status);
        messenger.setInfo("shortUrl",shortUrl);
        messenger = dSellerService.editSeller(messenger);
        return messenger;
    }

    @RequestMapping("/deleteSeller")
    @ResponseBody
    public MessengerVo deleteSeller(String uuid){
        MessengerVo messenger = new MessengerVo();
        messenger.setInfo("uuid",uuid);
        messenger = dSellerService.deleteSeller(messenger);
        return messenger;
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
        //PutObjectResult res = ossClient.putObject(bucketName, key, stream);
        //创建上传Object的Metadata
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(stream.available());
        objectMetadata.setCacheControl("no-cache");
        objectMetadata.setHeader("Pragma", "no-cache");
        objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
        objectMetadata.setContentDisposition("inline;filename=" + fileName);
        PutObjectResult res = ossClient.putObject(bucketName, key, stream, objectMetadata);
        System.out.println("res>>>>>>>>>>>>>>>>>>>>>>>>>>>"+res.getETag());
        // 设置URL过期时间为10年
        Date expiration = DateUtil.parseRfc822Date("Wed, 18 Mar 2217 14:20:00 GMT");
        //Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        vo.setInfo("url",url);
        System.out.println(vo);
        // 关闭client
        ossClient.shutdown();

        return vo;
    }

    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    public static void main(String[] args) {

    }
}
