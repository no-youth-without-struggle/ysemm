package com.aaa.ysemm.manage.service;

import java.util.List;
import java.util.Map;

public interface RefundService {
    List<Map> queryRefund(Map map);
    //分页
    int Page(Map map);
}
