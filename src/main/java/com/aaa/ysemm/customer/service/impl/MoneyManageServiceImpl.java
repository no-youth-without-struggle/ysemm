package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.MoneyManageMapper;
import com.aaa.ysemm.customer.service.MoneyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询是否还有待还款的资金，如果没有更改借款状态为已完成还款
     * @param map
     */
    @Transactional
    @Override
    public void getPeriods(Map map) {
        List<Map<String,Object>> count=moneyManageMapper.getPeriods(map);
        //判断当前用户是否还有待还款项
        if (count==null || count.size()<=0){
            //将当前的借款状态改为已完成
            moneyManageMapper.updateLoans(map);
        }

    }
}
