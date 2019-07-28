package com.aaa.ysemm.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
　　* 类描述： 手机验证码
　　* 创建人：白帅
　　* 创建时间：2019-1-12 下午2:27:22   
　　* @version        
　　*/
public class PhotoUtil {
   public static String getCode(String telephone){
        String host = "http://mobaitz.market.alicloudapi.com";
        String path = "/mobai_notifysms";
        String method = "POST";
        String appcode = "63656eba93124baab950f0bed2b5168c";
        Map<String, String> headers = new HashMap<String, String>();
        String randomNumber = RandomStringUtil.getRandomNumber(6);
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("param", "mark:【验证码为："+randomNumber+"】");
        querys.put("phone", telephone);
        querys.put("templateId", "TP18040318");
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return randomNumber;
    }
    public static void main(String [] args){
        String code = PhotoUtil.getCode("18236595321");
        System.out.println(code);
    }
}
