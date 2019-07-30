package com.aaa.ysemm.manage.controller;


import com.aaa.ysemm.manage.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//后台审核
@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditService service;

//    分页展示所有借款信息
    @RequestMapping("/selectloans")
    public Object selectloans(@RequestBody Map map){
        Map map1 = new HashMap();
//        查询所有信息
        List<Map> list =  service.selectloans(map);
//        查询总数
        int count = service.count(map);
        map1.put("list",list);
        map1.put("count",count);
        return map1;
    }
//    审核登陆
    @RequestMapping("/pass")
    public String pass(@RequestBody Map map){
        int ok = service.pass(map);
        if(ok!=0){
           service.passone(map);
            return "成功";
        }
        return "不成功";
    }
}
