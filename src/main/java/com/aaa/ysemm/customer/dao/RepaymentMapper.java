package com.aaa.ysemm.customer.dao;

import com.aaa.ysemm.entity.UserLogin;
import com.alibaba.druid.sql.ast.statement.SQLForeignKeyImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * fileName:RepaymentMapper
 * description:
 * author:yangjunling
 * createTime:2019/7/31 11:26
 * version:1.0.0
 */
@Repository
public interface RepaymentMapper {
    /**
     * 查询还款信息
     */
    List<Map> queryRepayment(Map map);
    /**
     * 查询还款期限的信息 以及应还信息
     */
    List<Map> queryHKQX(Object obj);
    /**
     * 查询还款期限的信息 以及应还信息
     */
    List<Map> queryHKQX2(Integer uid);
    /**
     * 查询已经还款的 信息
     */
    List<Map> queryAHKQX(UserLogin obj);
    /**
     * 还款完之后修改用户的状态
     *
     */
    int updateRepaymentStatus(Object status);
    /**
     * 通过登录的账号判断账户金额是否能够还的本期的贷款
     */
    Map queryCM(Object uid);

}
