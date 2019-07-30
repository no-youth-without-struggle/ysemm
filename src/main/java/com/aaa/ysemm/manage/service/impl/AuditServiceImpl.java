package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.manage.dao.AuditDao;
import com.aaa.ysemm.manage.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditDao dao;

    @Override
    public List<Map> selectloans(Map map) {
        List<Map> list = dao.selectloans(map);
        return list;
    }

    @Override
    public int count(Map map) {
        int count = dao.count(map);
        return count;
    }

    @Override
    public int pass(Map map) {
        int ok = dao.pass(map);
        if(ok==0){
            return 0;
        }
        return 1;
    }

    @Override
    public void passone(Map map) {
        dao.passone(map);
    }
}
