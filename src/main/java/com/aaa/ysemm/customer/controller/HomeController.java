package com.aaa.ysemm.customer.controller;

import com.aaa.ysemm.customer.entity.UserLogin;
import com.aaa.ysemm.customer.entitys.Company;
import com.aaa.ysemm.customer.entitys.Loans;
import com.aaa.ysemm.customer.entitys.Pledge;
import com.aaa.ysemm.customer.service.HomeService;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
}
