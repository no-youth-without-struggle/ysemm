package com.aaa.ysemm.manage.controller;

import com.aaa.ysemm.customer.entity.TreeNode;
import com.aaa.ysemm.entity.Login;
import com.aaa.ysemm.manage.service.LoginService;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     * 获取Session中的登录信息
     * @param request
     * @return
     */
    @RequestMapping("getSession")
    public Object getSession(HttpServletRequest request){
        return (Map)request.getSession().getAttribute("emp");
    }
    /**
     * 登录方法
     * @return
     */
    @RequestMapping("/userLogin")
    public ResultUtil login(@RequestBody Map map, HttpSession session) {
        ResultUtil logins = loginService.getLogin(map,session);
        return logins;

    }

    /**
     * 获取动态权限树
     */
    @RequestMapping("/getTree")
    public List<TreeNode> getTree(HttpSession session){
        List<TreeNode> loginMenu = (List<TreeNode>) session.getAttribute("loginMenu");
        return loginMenu;
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
