package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.CusManageMapper;
import com.aaa.ysemm.customer.service.CusManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public int updateMoney(Object reMoney) {
        int money = cusManageMapper.updateMoney(reMoney);
        if (money!=0){
            return money;
        }
        return 0;
    }
}
