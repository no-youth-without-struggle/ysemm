package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.LoginMapper;
import com.aaa.ysemm.customer.entity.UserLogin;
import com.aaa.ysemm.customer.service.LoginService;
import com.aaa.ysemm.util.MD5Util;
import com.aaa.ysemm.util.RandomStringUtil;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.service.impl
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/28 16:29
 * @Version: 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    //短信验证码
    String code=null;
    /**
     * 判断用户是否存在
     * @param telephone
     * @return
     */
    @Override
    public ResultUtil getTelehone(String telephone) {
        //判断是否有该用户
        Integer code=loginMapper.getTelephone(telephone);
        if(code==null){
          return  new ResultUtil(200,"该账户不存在",null);
        }
        return new ResultUtil(300,"该账户存在",null);
    }

    /**
     * md5加密并插入数据库完成申请
     * @param userLogin
     * @return
     */
    @Override
    public ResultUtil postForm(UserLogin userLogin) {
        //获取用户名、密码
        String password = userLogin.getPassword();
        String telephone = userLogin.getTelephone();
        userLogin.setTime(new Date());
        //加密
        Map<String, String> md5 = MD5Util.addMD5(telephone, password);
        userLogin.setPasswordSalt(md5.get("salt"));
        userLogin.setPassword(md5.get("password"));

        //随机生成用户名:ysemm+5位随机数
        String username="ysemm"+ RandomStringUtil.generateZeroString(5);
        System.out.println("username"+username);
        userLogin.setUsername(username);
        //将用户信息添加到数据库
        int status=loginMapper.postForm(userLogin);
        if (status>0){
            return new ResultUtil(200,"创建成功",null);
        }
        return new ResultUtil(400,"创建失败",null);
    }

    /**
     * 根据手机号查询并返回用户的信息
     * @param map
     * @return
     */
    @Override
    public List<Map> getSubmitLoin(Map map) {
        List<Map> submitLoin = loginMapper.getSubmitLoin(map);
        System.out.println("submit"+submitLoin);
        return submitLoin;
    }


}
