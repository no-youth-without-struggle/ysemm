package com.aaa.ysemm.manage.service.impl;
import com.aaa.ysemm.customer.entity.TreeNode;
import com.aaa.ysemm.manage.dao.LoginDao;
import com.aaa.ysemm.entity.Login;
import com.aaa.ysemm.manage.service.LoginService;
import com.aaa.ysemm.util.PasswordHelper;
import com.aaa.ysemm.util.ResultUtil;
import com.aaa.ysemm.util.TreeNodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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

    /**
     * 验证登录信息是否正确并显示该用户的权限菜单
     * @param map
     * @return
     */
    @Override
    public ResultUtil getLogin(Map map, HttpSession session) {
        //验证用户的账号密码是否正确
       List<Login> logins= loginDao.getLogin(map);
       if (logins==null&&logins.size()<=0){
            return new ResultUtil(ResultUtil.CODE_FAIL,ResultUtil.MSG_SUCCESS,null);
       }
        Login login = logins.get(0);
        session.setAttribute("login",login);
       //获取用户的权限菜单
        List<TreeNode> menu=loginDao.getLoginMenu(login.getLid());
        List<TreeNode> treeData = TreeNodeUtil.getPowerTreeData(menu);
        session.setAttribute("loginMenu",treeData);
        return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
    }

}
