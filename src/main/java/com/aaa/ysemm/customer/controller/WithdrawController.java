package com.aaa.ysemm.customer.controller;

import com.aaa.ysemm.customer.service.MingXiService;
import com.aaa.ysemm.customer.service.WithdrawService;
import com.aaa.ysemm.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * fileName:WithdrawController
 * description:
 * author:yangjunling
 * createTime:2019/8/7 15:12
 * version:1.0.0
 */
@RestController
@RequestMapping("withdraw")
public class WithdrawController {
    @Autowired
    private WithdrawService withdrawService;
    @Autowired
    private MingXiService mingXiService;
    @RequestMapping("queryMoney")
    public Map queryMoney(HttpSession session){
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        //登录信息的id
        Integer uid = emp.getUid();
        //返回查询的结果
        Map map = withdrawService.queryMoney(uid);
        return map;
    }

    /**
     * 充值金额
     * @return
     */
    @RequestMapping("saveMoney")
    public int saveMoney(@RequestBody Map map,HttpSession session){
        //获取当前系统时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());
        String type="充值";
        String nper="充值金额";
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        //登录信息的id
        Integer uid = emp.getUid();
        Map map1 = withdrawService.queryMoney(uid);
        map.put("uid",uid);
        map.put("cm_id",map.get("cid"));
        map.put("telephone",map.get("cname"));
        map.put("operatorTime",format);
        map.put("type",type);
        map.put("nper",nper);
        System.out.println(map.toString());
        //增加明细记录
        mingXiService.saveMingXi(map);
        // 充值
        return withdrawService.updateMoney(map);
    }
    /**
     * 金额提现
     */
      @RequestMapping("deleteMoney")
    public int deleteMoney(@RequestBody Map map,HttpSession session){
         //获取当前时间
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          String format = dateFormat.format(new Date());
          String type="提现";
          String nper="提现金额";
          UserLogin emp = (UserLogin) session.getAttribute("emp");
           //登录信息的id
          Integer uid = emp.getUid();
          map.put("uid",uid);
          map.put("cm_id",map.get("cid"));
          map.put("telephone",map.get("cname"));
          map.put("operatorTime",format);
          map.put("type",type);
          map.put("nper",nper);
            //增加明细记录
          mingXiService.saveMingXi(map);
            // 提现
          return  withdrawService.deleteMoney(map);
    }
}