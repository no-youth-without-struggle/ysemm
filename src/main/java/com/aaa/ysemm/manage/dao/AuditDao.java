package com.aaa.ysemm.manage.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AuditDao {
    List<Map> selectloans(Map map);

    int count(Map map);

    @Select("select count(*) from login where " +
            "email=#{email} and password=#{password}")
    int pass(Map map);
}
