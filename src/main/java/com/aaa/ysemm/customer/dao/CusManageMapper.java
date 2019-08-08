package com.aaa.ysemm.customer.dao;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * fileName:CusManageMapper
 * description:
 * author:yangjunling
 * createTime:2019/8/1 16:35
 * version:1.0.0
 */
@Repository
public interface CusManageMapper {
    /**
     *个人账户金额减去 还款金额
     */
    @Update("update customer_manager set total_money=total_money-#{reMoney} where uid=#{uid}")
    int updateMoney(Map map);
}
