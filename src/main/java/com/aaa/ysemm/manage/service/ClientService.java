package com.aaa.ysemm.manage.service;

import com.aaa.ysemm.manage.entity.Company;

import java.util.List;
import java.util.Map;

public interface ClientService {
    //查询
    List<Map> queryClinet(Map map);
    //分页
    int queryPage(Map map);
    //修改
    int update(Map map);
}
