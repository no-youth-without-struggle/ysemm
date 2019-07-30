package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.manage.dao.LoginDao;
import com.aaa.ysemm.manage.entity.Login;
import com.aaa.ysemm.manage.service.LoginService;
import com.aaa.ysemm.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:LoginServiceImpl
 * description:
 * author:yangjunling
 * createTime:2019/7/28 15:08
 * version:1.0.0
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public int saveReg(Login login) {
        PasswordHelper passwordHelper=new PasswordHelper();
        passwordHelper.encryptPassword(login);
        return loginDao.saveReg(login);
    }

    @Override
    public List<Map> queryLoginTWwo(Map map) {
        return loginDao.queryLoginTWwo(map);
    }
}
