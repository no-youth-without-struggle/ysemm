package com.aaa.ysemm.manage.controller;


import com.aaa.ysemm.manage.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * fileName:PowerController
 * description:
 * author:yangjunling
 * createTime:2019/7/30 13:20
 * version:1.0.0
 */
@Controller
@RequestMapping("powers")
public class PowersController {
    @Autowired
    private PowerService powerService;
    @RequestMapping("tree")
    @ResponseBody
    public Object tree(){
        return powerService.getPowerTreeData();
    }
}
