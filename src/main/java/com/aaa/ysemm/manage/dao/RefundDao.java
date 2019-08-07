package com.aaa.ysemm.manage.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface RefundDao {
    List<Map> queryRefund(Map map);
    //分页
    int Page(Map map);
}
