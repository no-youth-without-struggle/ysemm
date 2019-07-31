package com.aaa.ysemm.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.util
 * @Author: ${白帅}
 * @Description: md5加密工具包
 * @Date: 2019/7/29 9:39
 * @Version: 1.0
 */
public class MD5Util {

    public static Map<String, String> addMD5(String telephone, String password){
        Map<String, String> map = new HashMap<>();
        //加密方式
        String hashAlgorithmName = "MD5";
        String number = RandomStringUtil.getRandomNumber(4);
        System.out.println("number"+number);
        //盐值
        String salt=telephone.substring(0,6)+number;
        //次数
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        //加密
        Object obj = new SimpleHash(hashAlgorithmName, password, credentialsSalt, hashIterations);
        String pass = obj.toString();
        map.put("salt",salt);
        map.put("password",pass);
        return map;
    }

}
