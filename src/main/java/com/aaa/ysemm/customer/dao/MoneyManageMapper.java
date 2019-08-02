package com.aaa.ysemm.customer.dao;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * fileName:MoneyManageMapper
 * description:
 * author:yangjunling
 * createTime:2019/8/1 17:11
 * version:1.0.0
 */
@Repository
public interface MoneyManageMapper {
    /**
     *还款的金额加上公司的总金额 等于公司的总账
     */
    @Update("update money_manager set total_money=total_money+#{reMoney} where id=1")
    int updateManageMoney(Object reMoney);
}
