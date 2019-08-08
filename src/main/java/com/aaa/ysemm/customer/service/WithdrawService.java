package com.aaa.ysemm.customer.service;

import java.util.List;
import java.util.Map;

/**
 * fileName:WithdrawService
 * description:
 * author:yangjunling
 * createTime:2019/8/7 15:04
 * version:1.0.0
 */
public interface WithdrawService {
    /**
     * 前台提现
     */
    Map queryMoney(Integer uid);
    /**
     * 增加金额
     */
    int updateMoney(Map map);
    /**
     * 金额提现
     */
    int deleteMoney(Map map);

}
