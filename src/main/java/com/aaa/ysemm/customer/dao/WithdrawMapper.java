package com.aaa.ysemm.customer.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * fileName:WithdrawMapper
 * description:
 * author:yangjunling
 * createTime:2019/8/7 15:03
 * version:1.0.0
 */
@Repository
public interface WithdrawMapper {
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

    /**
     * 查询密码是否正确
     * @param map
     * @return
     */
    String getPayPassword(Map map);
}
