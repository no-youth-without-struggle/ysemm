package com.aaa.ysemm.manage.controller;

import com.aaa.ysemm.manage.entity.Company;
import com.aaa.ysemm.manage.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/query")
public class ClientController {
    @Autowired
    private ClientService clientService;
//分页查询
    @RequestMapping("/page")
    @ResponseBody
    public Object queryClient(@RequestBody Map map){
        Map map1=new HashMap();
       // List<Map> list = clientService.queryClinet(map);
        map1.put("list",clientService.queryClinet(map));
        map1.put("total",clientService.queryPage(map));
        return map1;
    }
//修改
    @RequestMapping("/update")
    public Object update(@RequestBody Map map){
        System.out.println(map);
       return clientService.update(map);
    }
}
