package com.aaa.ysemm.customer.dao;

import org.apache.ibatis.annotations.Insert;
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
}
