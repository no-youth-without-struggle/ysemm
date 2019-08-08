package com.aaa.ysemm.manage.service;

import com.aaa.ysemm.entity.Login;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.util.ResultUtil;

import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.service
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/7 19:58
 * @Version: 1.0
 */
public interface SecondAuditService {
    Map<String, Object> getCompany(PageUtil page);

    ResultUtil handleSuccess(Map map, Login login);

    ResultUtil handleFail(Map map, Login login);
}
