package com.aaa.ysemm.customer.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * fileName:MoneyManageService
 * description:
 * author:yangjunling
 * createTime:2019/8/1 17:16
 * version:1.0.0
 */
public interface MoneyManageService {
    /**
     *还款的金额加上公司的总金额 等于公司的总账
     */
    int updateManageMoney(Object reMoney);
}
