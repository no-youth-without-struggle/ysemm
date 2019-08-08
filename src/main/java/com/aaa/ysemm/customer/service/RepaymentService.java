package com.aaa.ysemm.customer.service;

import com.aaa.ysemm.customer.entity.MingXi;
import com.aaa.ysemm.entity.UserLogin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:RepaymentService
 * description:
 * author:yangjunling
 * createTime:2019/7/31 11:39
 * version:1.0.0
 */

public interface RepaymentService {
    /**
     * 查询还款信息
     */
    List<Map> queryRepayment(Map map);
    /**
     * 查询还款期限的信息 以及应还信息
     */
    List<Map> queryHKQX(UserLogin obj);
    /**
     * 查询还款期限的信息 以及应还信息
     */
    List<Map> queryHKQX2(UserLogin obj);
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
