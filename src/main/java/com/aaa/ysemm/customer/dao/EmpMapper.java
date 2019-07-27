package com.aaa.ysemm.customer.dao;

import com.aaa.ysemm.customer.entity.Dept;
import com.aaa.ysemm.customer.entity.Emp;
import com.aaa.ysemm.customer.entity.Page;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.mapper
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/18 19:30
 * @Version: 1.0
 */
public interface EmpMapper {
    List<Emp> getEmp(Page page);

    List<Dept> getDept();

    Integer getCount(Page page);

    Emp getUpdateEmp(Integer deptno);

    Integer updateEmp(Emp emp);

    Integer insertEmp(Emp emp);

    Integer deleteEmp(Integer empno);
}
