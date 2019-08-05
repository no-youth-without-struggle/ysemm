package com.aaa.ysemm.customer.controller;

import com.aaa.ysemm.customer.service.FkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fk")
public class FKController {
    @Autowired
    private FkService fkService;

    @RequestMapping("/queryFK")
    public List<Map> queryFK(){
        List<Map> map=fkService.queryFK();
        return map;
    }

    /**
     * 根据需求进行放款业务
     * @param cid
     * @param
     * @return
     */
    @RequestMapping("/queryZj")
    public Map queryZj(Integer cid){
        Map result= fkService.loanMoney(cid);
        return result;
    }
}
