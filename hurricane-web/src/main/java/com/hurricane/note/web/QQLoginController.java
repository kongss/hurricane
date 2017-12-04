package com.hurricane.note.web;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/12/4.
 */
@Controller
public class QQLoginController {

    @Value("${AccessTokenUrl}")
    String AccessTokenUrl;

    @Value("${OpenIDUrl}")
    String OpenIDUrl;

    @Value("${OpenApiUrl}")
    String OpenApiUrl;

    @RequestMapping("user/qqLogin")
    void qQLogin(String code,String state) throws Exception{
        if (StringUtils.isEmpty(code)){
            System.out.println("QQ登陆异常,请联系管理员");
        }
        Map<String, Object> map = getOpenId(code);
        String openId = String.valueOf(map.get("OpenId"));
        String AccessToken = String.valueOf(map.get("AccessToken"));
        boolean isExist = checkIsExist(openId);
        if (isExist){
            //该用户已经存在，直接查询个人信息
            System.out.println("该用户已经存在，直接查询个人信息");
        }else {
            //调用OpenAPI接口，获取登陆人信息入库操作
            System.out.println("调用OpenAPI接口，获取登陆人信息入库操作");
            OpenApiUrl = OpenApiUrl +"&access_token="+AccessToken+"&openid="+openId;
            System.out.println("OpenApiUrl="+OpenApiUrl);
            // 根据地址获取请求
            HttpGet request_Api = new HttpGet(OpenApiUrl);//这里发送get请求
            // 获取当前客户端对象
            HttpClient httpClient_Api = new DefaultHttpClient();
            // 通过请求对象获取响应对象
            HttpResponse response_Api = httpClient_Api.execute(request_Api);
            if (response_Api.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String res = EntityUtils.toString(response_Api.getEntity(), "utf-8");
                System.out.println("调用OpenAPI接口 res:"+res);
            }

        }
    }
    boolean checkIsExist(String openId){
        boolean flag = false;
        System.out.println("查询数据库是否存在此openId:"+openId);
        //查询数据库是否存在
        return flag;
    }
    Map<String, Object> getOpenId(String code){
        HashMap<String, Object> map = new HashMap<>();
        String OpenId = "";
        try {
            //Step2：通过Authorization Code获取Access Token
            AccessTokenUrl = AccessTokenUrl +code;
            String AccessToken = "";
            // 根据地址获取请求
            HttpGet request_Token = new HttpGet(AccessTokenUrl);//这里发送get请求
            // 获取当前客户端对象
            HttpClient httpClient_Token = new DefaultHttpClient();
            // 通过请求对象获取响应对象
            HttpResponse response_Token = httpClient_Token.execute(request_Token);
            // 判断网络连接状态码是否正常(0--200都数正常)
            if (response_Token.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String res= EntityUtils.toString(response_Token.getEntity(),"utf-8");
                System.out.println("result："+res);
                String[] split = res.split("&");
                for (int i=0;i<split.length;i++){
                    String sub = split[i];
                    String[] s = sub.split("=");
                    String key = s[0];
                    String value = s[1];
                    if ("access_token".equals(key)){
                        AccessToken = value;
                        map.put("AccessToken",AccessToken);
                    }
                }
            }
            //Step3：权限自动续期，获取Access Token（可选）
            //Step4：获取用户OpenID
            OpenIDUrl = OpenIDUrl + AccessToken;
            HttpGet request_OpenID = new HttpGet(OpenIDUrl);//这里发送get请求
            HttpClient httpClient_OpenID = new DefaultHttpClient();
            HttpResponse response_OpenID = httpClient_OpenID.execute(request_OpenID);
            if (response_OpenID.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String res= EntityUtils.toString(response_OpenID.getEntity(),"utf-8");
                System.out.println("获取用户OpenID："+res);
                res  = res.substring(res.indexOf("(")+1,res.indexOf(")"));
                System.out.println("截取后json串"+res);
                JSONObject object = JSONObject.parseObject(res.trim());
                String client_id = object.getString("client_id");
                String openid = object.getString("openid");
                System.out.println("client_id:"+client_id+"  openid:"+openid);
                OpenId = openid;
                map.put("OpenId",OpenId);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return map;
    }

    public static void main(String[] args) {
        String res1 = "access_token=57D94D306257DB4AB461F839BB0EABFE&expires_in=7776000&refresh_token=63260E6EE70638D841888BD061C1B16E";
        String res = "callback( {\"client_id\":\"101357263\",\"openid\":\"61F18BF351C1D738FA237DC884269A0B\"} );";
        res  = res.substring(res.indexOf("(")+1,res.indexOf(")"));
        System.out.println(res);

        JSONObject object = JSONObject.parseObject(res.trim());
        String client_id = object.getString("client_id");
        String openid = object.getString("openid");
        System.out.println(client_id);
        System.out.println(openid);




        /*String[] split = res.split("&");
        for (int i=0;i<split.length;i++){
            String sub = split[i];
            String[] s = sub.split("=");
            String key = s[0];
            String value = s[1];
            if ("access_token".equals(key)){
                System.out.println(value);
            }
        }*/

    }
}
