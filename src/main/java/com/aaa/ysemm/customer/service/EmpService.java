package com.aaa.ysemm.customer.service;

import com.aaa.ysemm.customer.entity.Emp;
import com.aaa.ysemm.customer.entity.Page;


import java.util.Map;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.service
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/18 19:23
 * @Version: 1.0
 */
public interface EmpService {
    Map<String, Object> getLogin(Page page);

    Emp getUpdateEmp(Emp emp);

    Map updateEmp(Emp emp);

    Map insertEmp(Emp emp);

    Map deleteEmp(Emp emp);
}
