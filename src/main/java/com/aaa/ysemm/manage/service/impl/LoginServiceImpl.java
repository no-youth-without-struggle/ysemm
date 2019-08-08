package com.aaa.ysemm.manage.service.impl;
import com.aaa.ysemm.customer.entity.TreeNode;
import com.aaa.ysemm.manage.dao.LoginDao;
import com.aaa.ysemm.entity.Login;
import com.aaa.ysemm.manage.service.LoginService;
import com.aaa.ysemm.util.PasswordHelper;
import com.aaa.ysemm.util.TreeNodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * 验证登录信息是否正确
     * @param map
     * @return
     */
    @Override
    public Map getLogin(Map map) {
        Map<String, Object> hashMap = new HashMap<>();
        //验证用户的账号密码是否正确
       List<Login> logins= loginDao.getLogin(map);
       if (logins==null&&logins.size()<=0){
            return hashMap;
       }
        Login login = logins.get(0);
        hashMap.put("login",login);
       //获取用户的角色信息
       List<Map> roles= loginDao.getRole(login);
       hashMap.put("roles",roles);
       return hashMap;
    }

    /**
     * 获取权限菜单
     * @param rid
     * @return
     */
    @Override
    public List<TreeNode> getLoginMenu(Integer rid) {
        //查询该角色下的所有权限
        List<TreeNode> menu=loginDao.getLoginMenu(rid);
        List<TreeNode> treeData = TreeNodeUtil.getPowerTreeData(menu);
        return treeData;
    }

}
