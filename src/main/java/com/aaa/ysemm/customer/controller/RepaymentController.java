package com.aaa.ysemm.customer.controller;


import com.aaa.ysemm.customer.entity.MingXi;
import com.aaa.ysemm.customer.entity.UserLogin;
import com.aaa.ysemm.customer.service.MingXiService;
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
    public List<Map> queryHKQX(Object obj, HttpServletRequest request){
        //获取登陆里面的 登陆账号的信息
        Object emp = request.getSession().getAttribute("emp");
//        通过信息查询当前账户的还款余额
        List<Map> queryHKQX = repayService.queryHKQX(emp);
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
//    @RequestMapping("queryCM")
//    public List<Map> queryCM(@RequestBody Object uid,HttpServletRequest request){
//        System.out.println("...................");
//        //获取登陆里面的 登陆账号的信息
//        Object emp = request.getSession().getAttribute("emp");
//        List<Map> mapList = repayService.queryCM(emp);
//        for (Map map1 : mapList) {
//            System.out.println(map1+".....");
//        }
//        return mapList;
//    }
    @RequestMapping("pub")
    public Object p(@RequestBody Map map){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(new Date());
        System.out.println(format);
        map.put("operatorTime",format);
        System.out.println(map.get("row"));
        System.out.println(map.get("rid"));
        Object rid = map.get("rid");
//        System.out.println(rid);
//        System.out.println(map.get("status"));
//        Object status = map.get("status");
//        System.out.println(status);
        repayService.updateRepaymentStatus(rid);
        int i = mingXiService.saveMingXi(map);
        System.out.println(i+"添加成功！");
        return map;
    }
}
