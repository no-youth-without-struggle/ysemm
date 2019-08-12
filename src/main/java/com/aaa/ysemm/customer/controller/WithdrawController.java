package com.aaa.ysemm.customer.controller;

import com.aaa.ysemm.customer.service.MingXiService;
import com.aaa.ysemm.customer.service.WithdrawService;
import com.aaa.ysemm.entity.UserLogin;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


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
    public ResultUtil saveMoney(@RequestBody Map map, HttpSession session){
        //判断当前支付密码是否正确
        String payPassword=withdrawService.getPayPassword(map);
            if (payPassword==null||payPassword==""){
                return new ResultUtil(ResultUtil.CODE_OTHER,"支付密码不正确",null);
            }
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
        int i = withdrawService.updateMoney(map);
        if (i>0){
            return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
        }
        return new ResultUtil(ResultUtil.CODE_FAIL,ResultUtil.MSG_FAIL,null);
    }
    /**
     * 金额提现
     */
      @RequestMapping("deleteMoney")
    public ResultUtil deleteMoney(@RequestBody Map map,HttpSession session){
          //判断当前支付密码是否正确
          String payPassword=withdrawService.getPayPassword(map);
          if (payPassword==null||payPassword==""){
              return new ResultUtil(ResultUtil.CODE_OTHER,"支付密码不正确",null);
          }
         //获取当前时间
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          String format = dateFormat.format(new Date());
          String type="提现";
          String nper="提现金额";
          UserLogin emp = (UserLogin) session.getAttribute("emp");
           //登录信息的id
          Integer uid = emp.getUid();
          map.put("uid",uid);
          //添加到明细表里面的信息需要 设置
          map.put("cm_id",map.get("cid"));
          map.put("telephone",map.get("cname"));
          map.put("operatorTime",format);
          map.put("type",type);
          map.put("nper",nper);
            //增加明细记录
          mingXiService.saveMingXi(map);
            // 提现
          int i = withdrawService.deleteMoney(map);
          if (i>0){
              return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
          }
          return new ResultUtil(ResultUtil.CODE_FAIL,ResultUtil.MSG_FAIL,null);
      }
}