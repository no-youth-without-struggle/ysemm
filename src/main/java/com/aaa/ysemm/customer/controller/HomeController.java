package com.aaa.ysemm.customer.controller;

import com.aaa.ysemm.entity.UserLogin;
import com.aaa.ysemm.customer.service.HomeService;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.util.PhotoUtil;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.controller
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/31 16:48
 * @Version: 1.0
 */
@RestController
@RequestMapping("/homeBorrow")
public class HomeController {
    @Autowired
    private HomeService service;

    /**
     * 获取借款人的信息
     * @return
     */
    @RequestMapping("/getCompany")
    public ResultUtil getConpany(HttpSession session){
       UserLogin emp = (UserLogin) session.getAttribute("emp");
       System.out.println(emp);
        return service.getCompany(emp);
    }
    /**
     * 添加借款人信息
     */
    @RequestMapping("/postBorrow")
    public ResultUtil postBorrow(@RequestBody Map map,HttpSession session){
        UserLogin userLogin = (UserLogin) session.getAttribute("emp");
       map.put("uid",userLogin.getUid());
        ResultUtil resultUtil = service.postBorrow(map);
        return resultUtil;
    }
    /**
     * 前台动态获取借款信息
     */
    @RequestMapping("/allMoney")
    public Map allMoney(@RequestBody Map map){
       return  service.getAllMoney(map);
    }
    /**
     * 查看借款人是否有资格
     */
    @RequestMapping("/getBorrowQualification")
    public ResultUtil getBorrowQualification(HttpSession session){
        UserLogin userLogin = (UserLogin) session.getAttribute("emp");
        ResultUtil resultUtil = service.getBorrowQualification(userLogin);
        return resultUtil;
    }
    /**
     * 获取用户的资金情况
     */
    @RequestMapping("/getFund")
    public Map<String,Object> getFund(HttpSession session){
        UserLogin userLogin = (UserLogin) session.getAttribute("emp");
       return service.getFund(userLogin);
    }

    /**
     * 根据资金类型查询资金记录
     */
    @RequestMapping("/getMoneyRecord")
    public Map<String,Object> getMoneyRecord(@RequestBody PageUtil page,HttpSession session){
        UserLogin userLogin = (UserLogin) session.getAttribute("emp");
        page.setId(userLogin.getUid());
        return service.getMoneyRecord(page);
    }
    /**
     * 获取登录用户的手机号码
     */
    @RequestMapping("/getTelephone")
    public Map<String,Object> getTelephone(HttpSession session){
        Map<String, Object> map = new HashMap<>();
        UserLogin userLogin = (UserLogin) session.getAttribute("emp");
        String telephone = userLogin.getTelephone();
        map.put("telephone",telephone);
        return map;
    }

    /**
     * 获取支付密码的手机验证码
     */
    @RequestMapping("/getPayCode")
    public void  getPayCode(String telephone,HttpSession session){
     /*   String code = RandomStringUtil.getRandomNumber(6);*/
         String code = PhotoUtil.getCode(telephone);
        System.out.println("code"+code);
        session.setAttribute("payCode",code);
    }
    /**
     * 更新支付密码
     */
    @RequestMapping("/postPaypassword")
    public ResultUtil postPaypassword(@RequestBody Map map,HttpSession session){
        String telephonePayCode = (String) session.getAttribute("payCode");
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        map.put("uid",emp.getUid());
        String payCode = (String) map.get("payCode");
        if (!telephonePayCode.equals(payCode)){
            return new ResultUtil(ResultUtil.CODE_OTHER,"验证码输入错误，请重新输入",null);
        }
        return service.postPaypassword(map);
    }
    /**
     * 获取登录密码的手机验证码
     */
    @RequestMapping("/getLoginCode")
    public void  getLoginCode(String telephone,HttpSession session){
      /*  String code = RandomStringUtil.getRandomNumber(6);*/
        String code = PhotoUtil.getCode(telephone);
        System.out.println("code"+code);
        session.setAttribute("LoginPasswordCode",code);
    }
    /**
     * 更新登录密码
     */
    @RequestMapping("/postLoginPassword")
    public ResultUtil postLoginPassword(@RequestBody Map map,HttpSession session){
        String telephoneLoginCode = (String) session.getAttribute("LoginPasswordCode");
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        map.put("uid",emp.getUid());
        map.put("passwordSalt",emp.getPasswordSalt());
        String loginPasswordCode = (String) map.get("loginPasswordCode");
        if (!telephoneLoginCode.equals(loginPasswordCode)){
            return new ResultUtil(ResultUtil.CODE_OTHER,"验证码输入错误，请重新输入",null);
        }
        return service.postLoginPassword(map);
    }
}
