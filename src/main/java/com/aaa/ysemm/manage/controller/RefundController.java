package com.aaa.ysemm.manage.controller;

import com.aaa.ysemm.manage.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/refund")
public class RefundController {

    @Autowired
    private RefundService refundService;
    //分页查询
    @RequestMapping("/page1")
    @ResponseBody
    public Object queryClient(@RequestBody Map map){
        Map map1=new HashMap();
        map1.put("list1",refundService.queryRefund(map));
        map1.put("total1",refundService.Page(map));
        return map1;
    }
}
