package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.CusManageMapper;
import com.aaa.ysemm.customer.service.CusManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * fileName:CusManageServiceImpl
 * description:
 * author:yangjunling
 * createTime:2019/8/1 17:07
 * version:1.0.0
 */

@Service
public class CusManageServiceImpl implements CusManageService {
    @Autowired
    private CusManageMapper cusManageMapper;
    @Override
    public int updateMoney(Map map) {
        int money = cusManageMapper.updateMoney(map);
        if (money!=0){
            return money;
        }
        return 0;
    }
}
