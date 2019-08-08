package com.aaa.ysemm.customer.service;

import com.aaa.ysemm.entity.UserLogin;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.util.ResultUtil;

import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.service
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/31 16:55
 * @Version: 1.0
 */
public interface HomeService {
    ResultUtil getCompany(UserLogin emp);

    ResultUtil postBorrow(Map map);


    Map getAllMoney(Map map);

    ResultUtil getBorrowQualification(UserLogin userLogin);

    Map<String, Object> getFund(UserLogin userLogin);

    Map<String, Object> getMoneyRecord(PageUtil page);

    ResultUtil postPaypassword(Map map);

    ResultUtil postLoginPassword(Map map);
}
