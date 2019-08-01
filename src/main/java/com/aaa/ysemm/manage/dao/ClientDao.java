package com.aaa.ysemm.manage.dao;

import com.aaa.ysemm.manage.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClientDao {
    //查询
    List<Map> queryClinet(Map map);
    //分页
    int queryPage(Map map);
    //修改
    int update(Map map);
}
