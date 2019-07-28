package com.aaa.ysemm.util;
/**
短信通知
 商品购买地址：https://market.aliyun.com/products/57126001/cmapi025334.html
 String host = "http://smsmsgs.market.alicloudapi.com"; //服务器
 String path = "/smsmsgs"; //接口地址
 */


import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class FegineApi {
    public static void main(String[] args) {
        String host = "http://smsmsgs.market.alicloudapi.com";
        String path = "/smsmsgs";
        String method = "GET";
        System.out.println("请先替换成自己的AppCode");
        String appcode = "63656eba93124baab950f0bed2b5168c";  // !!! 替换这里填写你自己的AppCode 请在买家中心查看
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode); //格式为:Authorization:APPCODE 83359fd73fe11248385f570e3c139xxx
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("param", "郭靖|12|5000");// !!! 请求参数
        querys.put("phone", "18236595321");// !!! 请求参数
        querys.put("sign", "1");
        querys.put("skin", "1002");// !!! 请求参数
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString()); //输出头部
            System.out.println(EntityUtils.toString(response.getEntity())); //输出json
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
