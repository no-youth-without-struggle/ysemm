package com.aaa.ysemm.customer.dao;

import com.aaa.ysemm.customer.entity.UserLogin;
import com.aaa.ysemm.customer.entitys.Loans;
import com.aaa.ysemm.customer.entitys.Pledge;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

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

    int insertPledge(Object pledge);
}
