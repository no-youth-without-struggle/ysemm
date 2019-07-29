package com.aaa.ysemm.manage.controller;

import com.aaa.ysemm.manage.entity.Login;
import com.aaa.ysemm.manage.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * fileName:LoginController
 * description:
 * author:yangjunling
 * createTime:2019/7/28 15:09
 * version:1.0.0
 */
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 登录方法
     * @return
     */
    @RequestMapping("useLogin")
    public Login login(Login login){
        UsernamePasswordToken token = new UsernamePasswordToken(login.getEmail(),login.getPassword());
        Subject currentUser= SecurityUtils.getSubject();
        currentUser.login(token);
        return null;
    }
    /**
     * 注册方法
     */
    @RequestMapping("reg")
    public Integer saveReg(@RequestBody Login login){
        int reg= loginService.saveReg(login);
        if (reg!=0){
            return reg;
        }
        return 0;
    }
}
