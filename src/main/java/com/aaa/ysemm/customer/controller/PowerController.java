package com.aaa.ysemm.customer.controller;

import com.aaa.ysemm.customer.service.PowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.controller
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/20 10:03
 * @Version: 1.0
 */
@RestController
@RequestMapping("power")
public class PowerController {
    @Autowired
    private PowerService powerService;

    /**
     * 获取权限菜单数据
     */
    @RequestMapping("tree")
    public Object tree(){
        return powerService.getPowerTreeData();
    }
}
