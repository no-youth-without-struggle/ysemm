package com.aaa.ysemm.customer.controller;

import com.aaa.ysemm.customer.entity.UserLogin;
import com.aaa.ysemm.customer.service.CompanyCertificationService;
import com.aaa.ysemm.customer.service.impl.CompanyCertificationServiceImpl;
import com.aaa.ysemm.util.Base64Util;
import com.aaa.ysemm.util.FtpUtil;
import com.aaa.ysemm.util.IDCard;
import com.aaa.ysemm.util.ReverseIDCard;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/authentication")
public class CompanyCertificationController {

    @Autowired
    private CompanyCertificationService service;
    @Autowired
    private IDCard idCard;
    @Autowired
    private ReverseIDCard reverseIDCard;
    @Autowired
    private FtpUtil ftputil;

    @RequestMapping("/adduser")
    public String adduser(@RequestBody Map map,HttpSession session){
//      获取session
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        System.out.println(emp.getUid());
        map.put("uid",emp.getUid());

        service.adduser(map);
        return "成功";
    }

//上传图片，调用身份证ocr，添加数据库
    @RequestMapping("/upload")
    public Object upload(@RequestParam MultipartFile face_IDCard) throws IOException {
//        调用base64加密face_IDCard
        BASE64Encoder base64Encoder= new  BASE64Encoder();
        String encode = base64Encoder.encode(face_IDCard.getBytes());
        String cardInfo = idCard.getCardInfo(encode);
//        将获取到的身份证信息转换map
        Map tmap  = JSON.parseObject(cardInfo);
        Map map1  = JSON.parseObject(tmap.get("result")+"");
//        将图片保存到ftp服务器中
        String s = ftputil.upLoad(face_IDCard);
        map1.put("s",s);
//        调用service

        return null;
    }
}
