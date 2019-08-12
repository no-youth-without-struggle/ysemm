package com.aaa.ysemm.customer.service;

import java.util.List;
import java.util.Map;


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

    String getPayPassword(Map map);
}
