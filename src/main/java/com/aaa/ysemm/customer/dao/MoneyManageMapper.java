package com.aaa.ysemm.customer.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    @Select("SELECT re.re_money,re.re_balance from repayment re INNER JOIN loans l on re.lid=l.loan_id INNER JOIN\n" +
            "company c on l.loan_cid=c.cid\n" +
            " WHERE re.lid=(SELECT lid from repayment where  rid=#{rid}) and `status`=0 and cid=#{cid}")
    List<Map<String, Object>> getPeriods(Map map);

    @Update("update loans set loans_status=5 where  loan_cid=#{cid} and loan_id=(SELECT lid from repayment where rid=#{rid})")
    void updateLoans(Map map);
}
