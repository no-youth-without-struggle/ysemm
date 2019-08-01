package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.RepaymentMapper;
import com.aaa.ysemm.customer.entity.MingXi;
import com.aaa.ysemm.customer.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:RepaymentServiceImpl
 * description:
 * author:yangjunling
 * createTime:2019/7/31 11:39
 * version:1.0.0
 */
@Service
public class RepaymentServiceImpl implements RepaymentService {
    @Autowired
    private RepaymentMapper repaymentMapper;

    @Override
    public List<Map> queryRepayment(Map map) {
        return repaymentMapper.queryRepayment(map);
    }

    @Override
    public List<Map> queryHKQX(Object obj) {
        List<Map> mapList = repaymentMapper.queryHKQX(obj);
        System.out.println("map"+mapList);
        return mapList;
    }

    @Override
    public int updateRepaymentStatus(Object status) {
        return repaymentMapper.updateRepaymentStatus(status);
    }

    @Override
    public List<Map> queryCM(Object uid) {
        List<Map> mapList = repaymentMapper.queryCM(uid);
        if (mapList!=null&&mapList.size()>0){
            return mapList;
        }
        return null;
    }

}
