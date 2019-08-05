package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.manage.dao.RefundDao;
import com.aaa.ysemm.manage.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class RefundServiceImpl implements RefundService {
    @Autowired
    private RefundDao refundDao;
    @Override
    public List<Map> queryRefund(Map map) {
        return refundDao.queryRefund(map);
    }

    @Override
    public int Page(Map map) {
        return refundDao.Page(map);
    }
}
