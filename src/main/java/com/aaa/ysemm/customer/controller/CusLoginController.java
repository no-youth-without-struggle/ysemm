package com.aaa.ysemm.customer.controller;
import com.aaa.ysemm.entity.UserLogin;
import com.aaa.ysemm.customer.service.CusLoginService;
import com.aaa.ysemm.util.PhotoUtil;
import com.aaa.ysemm.util.RandomStringUtil;
import com.aaa.ysemm.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;


/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.controller
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/28 15:23
 * @Version: 1.0
 */
@RestController
@RequestMapping("/beforelogin")
public class CusLoginController {

    @Autowired
     private CusLoginService service;
    /**
     * ajax异步获取手机验证码
     * @param telephone
     * @return
     */
    @RequestMapping("/getCode")
    public ResultUtil getCode(String telephone, HttpSession session){
       /* String code= RandomStringUtil.getRandomNumber(6);*/
        System.out.println(telephone);
        String code = PhotoUtil.getCode(telephone);
        System.out.println("code"+code);
        session.setAttribute("code",code);
        return new ResultUtil(200,"获取成功",null);

    }
    /**
     * ajax异步请求判断手机号是否重复
     */
    @RequestMapping("/getTelephone")
    public ResultUtil getTelephone(String telephone){
        return service.getTelehone(telephone);
    }
    /**
     * 提交信息，完成注册
     */
    @RequestMapping("/postForm")
    public ResultUtil postForm(@RequestBody UserLogin userLogin,HttpSession session){
        String code = (String) session.getAttribute("code");
        System.out.println(code+";"+userLogin.getPhonecode()+";"+code.equals(userLogin.getPhonecode()));
        if (code.equals(userLogin.getPhonecode())){
            return service.postForm(userLogin);
        }
        System.out.printf(userLogin.toString());
        return new ResultUtil(300,"验证码不正确",null);
    }
    /**
     * 使用shiro登录
     */
    @RequestMapping("/submitLoginForm")
    public ResultUtil getLoginForm(@RequestBody UserLogin userLogin){
        String telephone = userLogin.getTelephone();
        String password = userLogin.getPassword();
        Subject subject = SecurityUtils.getSubject();
        String msg="";
       if (telephone != null &&!"".equals(telephone)){
           UsernamePasswordToken token = new UsernamePasswordToken(telephone, password);
           try {
               subject.login(token);
           } catch (AuthenticationException exception) {
               //清除session
               token.clear();
               //自定义信息
               if (UnknownAccountException.class.getName().equals(exception+"")) {
                   msg = "您输入的账号密码不存在~";
               } else if (IncorrectCredentialsException.class.getName().equals(exception.getClass().getName())) {
                   msg = "您输入的账号密码不正确~";
               } else if (LockedAccountException.class.getName().equals(exception.getClass().getName()) ){
                   msg = " 您的账号已经被锁定 无法登入系统~";
               } else {
                   msg = "账号或者密码错误~";
               }
           }
       }
       if (msg==""){
           return new ResultUtil(200,"登录成功",null);
       }
        return new ResultUtil(400,"登录失败",null);
    }
}
