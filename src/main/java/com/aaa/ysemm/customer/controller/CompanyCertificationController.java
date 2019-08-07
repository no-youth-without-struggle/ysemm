package com.aaa.ysemm.customer.controller;

import com.aaa.ysemm.customer.entity.UserLogin;
import com.aaa.ysemm.customer.service.CompanyCertificationService;
import com.aaa.ysemm.util.FtpUtil;
import com.aaa.ysemm.util.IDCard;
import com.alibaba.fastjson.JSON;
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
    private FtpUtil ftputil;

    @RequestMapping("/adduser")
    public Map adduser(@RequestBody Map map,HttpSession session){
//      获取session
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        map.put("uid",emp.getUid());
        System.out.println(map);
        service.adduser(map);
        HashMap map1 = new HashMap();
        map1.put("ok","chenggong");
        return map1;
    }

//上传图片，调用身份证ocr，添加数据库
    @RequestMapping("/upload")
    public void upload(@RequestParam MultipartFile face_IDCard,HttpSession session) throws IOException {
//        调用base64加密face_IDCard
        BASE64Encoder base64Encoder= new  BASE64Encoder();
        String encode = base64Encoder.encode(face_IDCard.getBytes());
        String cardInfo = idCard.getCardInfo(encode);
//        将获取到的身份证信息转换map
        Map tmap  = JSON.parseObject(cardInfo);
        Map map1  = JSON.parseObject(tmap.get("result")+"");
//        获取session
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        Integer uid = emp.getUid();
//        将图片保存到ftp服务器中
        String s = ftputil.upLoad(face_IDCard);
        map1.put("s",s);
        map1.put("uid",uid);
//        调用service
        service.upload(map1);
    }
//    上传身份证反面
    @RequestMapping("/uploadanouther")
    public void uploadanouther(@RequestParam MultipartFile reverse_IDCard,HttpSession session) {
        String s = ftputil.upLoad(reverse_IDCard);
//        获取session
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        Integer uid = emp.getUid();
        System.out.println(uid);
//        调用service
        service.uploadanouther(s,uid);
    }
//    上传营业执照
    @RequestMapping("/businesslicense")
    public void businesslicense(@RequestParam MultipartFile businesslicense,HttpSession session){
        String s = ftputil.upLoad(businesslicense);
//        调用session
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        Integer uid = emp.getUid();
//        调用service
        service.businesslicense(s,uid);
    }
}
