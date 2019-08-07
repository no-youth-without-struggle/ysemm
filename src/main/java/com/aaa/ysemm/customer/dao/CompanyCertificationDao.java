package com.aaa.ysemm.customer.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CompanyCertificationDao {
    @Insert("insert into company " +
            "(uid,cname,email,telephone,phone,nature" +
            ",address,bankCard) values " +
            "(#{uid},#{cname},#{email},#{telephone}," +
            "#{phone},#{nature},#{address},#{bankCard})")
    void adduser(Map map);

    @Update("update company set reverse_IDCard=#{s} where uid=#{uid}")
    void uploadanouther(String s, Integer uid);

    @Update("update company set business_license=#{s} where uid=#{uid}")
    void businesslicense(String s, Integer uid);

    @Update("update company set pname=#{name},IDCard=#{code},sex=#{sex}" +
            " where uid=#{uid}")
    void upload(Map map1);
}
