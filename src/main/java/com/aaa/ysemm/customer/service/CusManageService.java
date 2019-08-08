package com.aaa.ysemm.customer.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * fileName:CusManageService
 * description:
 * author:yangjunling
 * createTime:2019/8/1 16:59
 * version:1.0.0
 */
public interface CusManageService {
    /**
     *个人账户金额减去 还款金额
     */
    int updateMoney(Map map);
}
