package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.MoneyManageMapper;
import com.aaa.ysemm.customer.service.MoneyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * fileName:MoneyManageServiceImpl
 * description:
 * author:yangjunling
 * createTime:2019/8/1 17:16
 * version:1.0.0
 */
@Service
public class MoneyManageServiceImpl implements MoneyManageService {
    @Autowired
    private MoneyManageMapper moneyManageMapper;
    @Override
    public int updateManageMoney(Object reMoney) {
//        if (reMoney)
        int money = moneyManageMapper.updateManageMoney(reMoney);
        if (money>0){
            return money;
        }
        return 0;
    }
}
