package com.aaa.ysemm.util;
;
import com.aaa.ysemm.manage.entity.Login;
import com.aaa.ysemm.manage.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;
    //实现用户的身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始身份认证：");
        //获取用户名 ：从登录页面传递过来的用户名
//        authenticationToken.getPrincipal();
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();//获取用户名
//        char[] password=token.getPassword();//获取密码

        //查询数据是否存在用户名
        System.out.println("用户名："+username);

        //根据用户名：账号：从数据中查询用户名对应的密码
        Login login= loginService.queryLogin(new Login(username));
//        String password="123456";

        /**
         * 要求返回
         */
        Object principal=login.getEmail();

        Object credentials=login.getPassword();
        //获取类的名字 MyRealm
        String realmName=getName();
        ByteSource credentialsSalt=  ByteSource.Util.bytes(username);

        //存的数据从数据库中取出来的用户的名字 和密码
        AuthenticationInfo info=new SimpleAuthenticationInfo(principal,credentials,credentialsSalt,realmName);
        return info;
    }

    //实现授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取主身份信息
        Object username=principalCollection.getPrimaryPrincipal();
        //根据用户名获取对应的角色

        Set<String> role=new HashSet<>();
        role.add("admin");
        role.add("guest");
        role.add("test");

        //返回的对应得的 AuthorizationInfo 的实现类的对象

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setRoles(role);
        return info;
    }
}
