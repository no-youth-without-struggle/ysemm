package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.EmpMapper;
import com.aaa.ysemm.customer.entity.Dept;
import com.aaa.ysemm.customer.entity.Emp;
import com.aaa.ysemm.customer.entity.Page;
import com.aaa.ysemm.customer.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.service.impl
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/18 19:24
 * @Version: 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper mapper;
    @Override
    public Map<String, Object> getLogin(Page page) {
        HashMap<String, Object> mapAll= new HashMap<>();
        //获取员工表的信息
        List<Emp> emp= mapper.getEmp(page);
        //获取部门表信息
        List<Dept> dept=mapper.getDept();
        //获取总数
        Integer count=mapper.getCount(page);
        mapAll.put("list",emp);
        mapAll.put("dept",dept);
        mapAll.put("counts",count);
        return mapAll;
    }

    @Override
    public Emp getUpdateEmp(Emp emp) {
        return mapper.getUpdateEmp(emp.getEmpno());
    }

    /**
     * 更改数据
     * @param emp
     * @return
     */
    @Override
    public Map updateEmp(Emp emp) {
     Map<Object, Object> map = new HashMap<>();
        Integer code= mapper.updateEmp(emp);
        if (code==0){
            map.put("code",400);
        }else{
            map.put("code",200);
        }
        return map;

    }

    /**
     * 添加操作
     * @param emp
     * @return
     */
    @Override
    public Map insertEmp(Emp emp) {
        Map<Object, Object> map = new HashMap<>();
        Integer result=mapper.insertEmp(emp);
        if (result==0){
            map.put("code",400);
        }else{
            map.put("code",200);
        }
        return map;
    }

    /**
     * 删除操作
     * @param emp
     * @return
     */
    @Override
    public Map deleteEmp(Emp emp) {
        Map<Object, Object> map = new HashMap<>();
        System.out.println(emp.getEmpno());
        Integer result=mapper.deleteEmp(emp.getEmpno());
        if (result==0){
            map.put("code",400);
        }else{
            map.put("code",200);
        }
        return map;
    }
}
