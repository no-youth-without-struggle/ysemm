package com.aaa.ysemm.manage.service;

import com.aaa.ysemm.entity.Employee;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.util.ResultUtil;

import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.service
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/3 16:39
 * @Version: 1.0
 */
public interface ManagerService {
    Map<String, Object> getEmp(PageUtil map);

    Map<String, Object> getMenu();

    ResultUtil postEmp(Employee employee);

    ResultUtil updateEmp(Map map);
}
