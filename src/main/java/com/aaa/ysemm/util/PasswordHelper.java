package com.aaa.ysemm.util;

import com.aaa.ysemm.manage.entity.Login;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    //要加密的方式
    private String hashAlgorithmName="MD5";
    //迭代的次数
    private Integer hashIterations=1024;

    public void encryptPassword(Login login){
        //原始密码
        String source=login.getPassword();
        //盐
        ByteSource credentialsSalt=ByteSource.Util.bytes(login.getEmail());
        String credentials=new SimpleHash(hashAlgorithmName,source,credentialsSalt,hashIterations).toHex();
        //设置加密后的密码
        login.setPassword(credentials);
    }

}
