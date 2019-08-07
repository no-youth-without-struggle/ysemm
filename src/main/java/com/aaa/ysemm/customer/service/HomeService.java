package com.aaa.ysemm.customer.service;

import com.aaa.ysemm.customer.entity.UserLogin;
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
}
