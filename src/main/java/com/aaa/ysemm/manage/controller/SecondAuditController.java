package com.aaa.ysemm.manage.controller;

import com.aaa.ysemm.entity.Login;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.manage.service.SecondAuditService;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
    /**
     * 审核通过
     */
    @RequestMapping("/handleSuccess")
    public ResultUtil handleSuccess(@RequestBody Map map, HttpSession session){
        Login login = (Login) session.getAttribute("login");
        return service.handleSuccess(map,login);
    }


    /**
     * 审核驳回
     */
    @RequestMapping("/handleFail")
    public ResultUtil handleFail(@RequestBody Map map, HttpSession session){
        Login login = (Login) session.getAttribute("login");
        return service.handleFail(map,login);
    }
}
