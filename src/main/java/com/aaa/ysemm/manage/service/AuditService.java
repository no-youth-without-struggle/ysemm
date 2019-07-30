package com.aaa.ysemm.manage.service;

import java.util.List;
import java.util.Map;

public interface AuditService {
    List<Map> selectloans(Map map);

    int count(Map map);

    int pass(Map map);
}
