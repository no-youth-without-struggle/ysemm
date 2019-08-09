package com.aaa.ysemm.customer.controller;


import com.aaa.ysemm.customer.dao.CusManageMapper;
import com.aaa.ysemm.entity.UserLogin;
import com.aaa.ysemm.customer.service.MingXiService;
import com.aaa.ysemm.customer.service.MoneyManageService;
import com.aaa.ysemm.customer.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * fileName:RepaymentController
 * description:
 * author:yangjunling
 * createTime:2019/7/31 11:33
 * version:1.0.0
 */
@RestController
@RequestMapping("rep")
public class RepaymentController {
    @Autowired
    private RepaymentService repayService;
    @Autowired
    private MingXiService mingXiService;
    @Autowired
    private CusManageMapper cusManageMapper;
    @Autowired
    private MoneyManageService moneyManageService;
    /**
     * 查询借款记录
     * @param map
     * @return
     */
    @RequestMapping("queryLog")
    public List<Map> queryLog(Map map){
        List<Map> queryLog = repayService.queryRepayment(map);
        //判断对象里卖弄是否有值
        if (queryLog!=null&&queryLog.size()>0){
            return queryLog;
        }
        return null;
    }
    /**
     *还款信息查询
     */
    @RequestMapping("queryHKQX")
    public List<Map> queryHKQX(Object obj, HttpSession session){
        //获取登陆里面的 登陆账号的信息
        UserLogin emp = (UserLogin) session.getAttribute("emp");
//        通过信息查询当前账户的还款余额
        List<Map> queryHKQX = repayService.queryHKQX(emp);
        if (queryHKQX!=null&&queryHKQX.size()>0){
            return queryHKQX;
        }
        return null;
    }
    /**
     *全部还款信息查询
     */
    @RequestMapping("queryHKQX2")
    public List<Map> queryHKQX2(Object obj, HttpSession session){
        //获取登陆里面的 登陆账号的信息
        UserLogin emp = (UserLogin) session.getAttribute("emp");
//        通过信息查询当前账户的还款余额
        List<Map> queryHKQX2 = repayService.queryHKQX2(emp);
        if (queryHKQX2!=null&&queryHKQX2.size()>0){
            return queryHKQX2;
        }
        return null;
    }
    /**
     * 查询还款过的信息
     */
    @RequestMapping("queryAHKQX")
    public List<Map> queryAHKQX(Object obj, HttpSession session){
        //获取登陆里面的 登陆账号的信息
        UserLogin emp = (UserLogin) session.getAttribute("emp");
//        通过信息查询当前账户的还款余额
        List<Map> queryHKQX = repayService.queryAHKQX(emp);
        if (queryHKQX!=null&&queryHKQX.size()>0){
            return queryHKQX;
        }
        return null;
    }

    /**
     * 判断账户金额是否足够还本期的贷款
     * @param
     * @return
     */
    @RequestMapping("queryCM")
    public Map queryCM(HttpSession session){
        //获取登陆里面的 登陆账号的信息
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        //获取手机号码
        String telephone = emp.getTelephone();
//        通过手机号查询用户账户信息
        Map map = repayService.queryCM(telephone);
        return map;
    }
    @RequestMapping("pub")
    public Object p(@RequestBody Map map,HttpSession session){
        //获取登陆里面的 登陆账号的信息
        UserLogin emp = (UserLogin) session.getAttribute("emp");
        Integer uid = emp.getUid();
        map.put("uid",uid);
        //获取当前系统时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());
        map.put("telephone",map.get("cname"));
        map.put("operatorTime",format);
        Object reMoney = map.get("reMoney");
        Object uid1 = map.get("uid");
        System.out.println(uid1+"sda"+reMoney);
        Object rid = map.get("rid");
        repayService.updateRepaymentStatus(rid);
        //添加到明细表
        mingXiService.saveMingXi(map);
        //个人账户总金额 减去还款的金额
        cusManageMapper.updateMoney(map);
        //总金额加上还款金额
        moneyManageService.updateManageMoney(reMoney);
        //查询当前还有没有未还款的期数，如果没有，更改当前借款记录的状态
        moneyManageService.getPeriods(map);
        return map;
    }
}
