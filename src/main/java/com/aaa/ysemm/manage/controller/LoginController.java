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
    public Map login(@RequestBody Map map, HttpSession session){
        Map logins = loginService.getLogin(map);
        if (logins!=null){
            Login login = (Login) logins.get("login");
            session.setAttribute("login",login);
        }
        return logins;


      /*
        String userName= map.get("email")+"";
        String passWord = map.get("password")+"";
        System.out.println(map+".............................");
        Subject subject = SecurityUtils.getSubject();
        String msg="";
        if(userName!=null&&!"".equals(userName)) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord);
            try {
                subject.login(token);
                msg="suc";
            } catch (AuthenticationException exception) {
                //清除session
                token.clear();
                //自定义信息

                if (UnknownAccountException.class.getName().equals(exception+"")) {
                    msg = "您输入的账号不存在~";
                } else if (IncorrectCredentialsException.class.getName().equals(exception.getClass().getName())) {
                    msg = "您输入的密码不正确~";
                } else if (LockedAccountException.class.getName().equals(exception.getClass().getName()) ){
                    msg = " 您的账号已经被锁定 无法登入系统~";
                } else {
                    msg = "账号或者密码错误~";
                }
            }
        }
        Map mapTmp = new HashMap();
        mapTmp.put("msg",msg);
        return mapTmp;*/
    }

    /**
     * 获取权限菜单
     */
    @RequestMapping("/loginMenu")
    public ResultUtil getLoginMenu(Integer rid,HttpSession session){
        List<TreeNode> loginMenu = loginService.getLoginMenu(rid);
        session.setAttribute("loginMenu",loginMenu);
        return  new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
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
