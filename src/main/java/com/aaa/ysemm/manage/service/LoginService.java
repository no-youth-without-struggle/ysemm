package com.aaa.ysemm.manage.service;

import com.aaa.ysemm.manage.entity.Login;

import java.util.List;
import java.util.Map;

/**
 * fileName:CusLoginService
 * description:
 * author:yangjunling
 * createTime:2019/7/28 15:07
 * version:1.0.0
 */
public interface LoginService {
    /**
     * 管理员登录
     * @return
     */
    List<Map> queryLoginTWwo(Map map);
    /**
     * 用户注册
     * @return
     */
    int saveReg(Login login);


}
