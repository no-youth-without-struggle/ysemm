package com.aaa.ysemm.manage.controller;

import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.manage.service.SecondAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.controller
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/7 19:54
 * @Version: 1.0
 */
@RestController
@RequestMapping("/secondAudit")
public class SecondAuditController {
    @Autowired
    private SecondAuditService service;


    /**
     * 查询所有待二审借款信息
     */
    @RequestMapping("/getCompany")
    public Map<String,Object> getCompany(@RequestBody PageUtil page){
       return service.getCompany(page);
    }
}
