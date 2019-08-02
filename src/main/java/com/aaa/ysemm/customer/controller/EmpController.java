package com.aaa.ysemm.customer.controller;
import com.aaa.ysemm.customer.entity.Emp;
import com.aaa.ysemm.customer.entity.Page;
import com.aaa.ysemm.customer.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.controller
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/18 19:22
 * @Version: 1.0
 */
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页+搜索
     * @param
     * @return
     */
    @RequestMapping("/login")
    public Map<String,Object> getLogin(@RequestBody Page page){
        return empService.getLogin(page);
    }
    @RequestMapping("/update")
    public Emp getUpdateEmp(@RequestBody Emp emp){
        return empService.getUpdateEmp(emp);
    }
    @RequestMapping("/updateEmp")
    public Map updateEmp(@RequestBody Emp emp){
        return empService.updateEmp(emp);
    }
    /**
     * 添加操作
     */
    @RequestMapping("/insertEmp")
    public Map insertEmp(@RequestBody Emp emp){
        return empService.insertEmp(emp);
    }
    /**
     * 删除操作
     */
    @RequestMapping("/deleteEmp")
    public Map deleteEmp(@RequestBody Emp emp){
        return empService.deleteEmp(emp);
    }
}
