package com.aaa.ysemm.manage.dao;

import com.aaa.ysemm.manage.entity.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * fileName:LoginDao
 * description:
 * author:yangjunling
 * createTime:2019/7/28 15:05
 * version:1.0.0
 */
@Repository
public interface LoginDao {
    /**
     * 管理员登录
     * @return
     */
    @Select("select * from login where status=1 and email=#{email} and password=#{password}")
    Login queryLogin(Login login);
    /**
     * 用户注册
     */
    @Insert("insert into login(email,password) VALUES(#{email},#{password})")
    int saveReg(Login login);
}
