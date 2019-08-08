package com.aaa.ysemm.customer.dao;

import com.aaa.ysemm.entity.UserLogin;
import com.aaa.ysemm.customer.entitys.Company;
import com.aaa.ysemm.customer.entitys.Loans;
import com.aaa.ysemm.customer.entitys.Pledge;
import com.aaa.ysemm.manage.entity.PageUtil;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.dao
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/31 17:22
 * @Version: 1.0
 */

public interface HomeMapper {
    //根据登录人的id获取公司的信息
   Map<String,Object> getCompany(Integer uid);
   //添加借款信息
    int insertBorrow(Object borrow);

    void insertPledge(Object pledge);

    Integer getLogin(Object uid);

    String getCompanyQualification(UserLogin userLogin);

    List<Integer> getLoans(UserLogin userLogin);

    List<Integer> getRepayment(UserLogin userLogin);

    double getAllMoney(UserLogin userLogin);

    double getBorrowMoney(UserLogin userLogin);

    double repaymentMoney(UserLogin userLogin);

    List<Map> getMoneyRecord(PageUtil page);

    Integer getFund(PageUtil page);

    void postPaypassword(Map map);

    void postLoginPassword(Map map);
}
