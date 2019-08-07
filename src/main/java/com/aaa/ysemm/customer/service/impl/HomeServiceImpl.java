package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.HomeMapper;
import com.aaa.ysemm.entity.UserLogin;
import com.aaa.ysemm.customer.entitys.Company;
import com.aaa.ysemm.customer.entitys.Loans;
import com.aaa.ysemm.customer.entitys.Pledge;
import com.aaa.ysemm.customer.service.HomeService;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.util.AverageCapitalPlusInterestUtils;
import com.aaa.ysemm.util.AverageCapitalUtils;
import com.aaa.ysemm.util.MD5Util;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.service.impl
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/31 17:22
 * @Version: 1.0
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper mapper;

    /**
     * 获取借款人的信息
     * @param emp
     * @return
     */
    @Override
    public ResultUtil getCompany(UserLogin emp) {
        Map<String, Object> map = new HashMap<>();
        //获取登录用户的id
        Integer uid = emp.getUid();
        //根据id获取用的信息
         map=mapper.getCompany(uid);
        if (map==null){
            new ResultUtil(400,"没有数据",null);
        }
        return new ResultUtil(200,"成功",map);
    }

    /**
     * 添加借款信息
     * @param map
     * @return
     */
    @Transactional
    @Override
    public ResultUtil postBorrow(Map map) {
        System.out.println("map"+map);
        //根据uid查询企业信息

        Integer cid=mapper.getLogin(map.get("uid"));
        if (cid==null){
            return new ResultUtil(300,"查无此企业",null);
        }
        map.put("loanCid",cid);
        //添加借款信息
       mapper.insertPledge(map);
       map.put("applyTime",new Date());
       Integer lid= mapper.insertBorrow(map);
        return new ResultUtil(200,"操作成功",null);
    }

    /**
     * 动态展示借款数据
     * @param map
     * @return
     */
    @Override
    public Map getAllMoney(Map map) {
        Map<String, Object> maps = new HashMap<>();
        String type = (String) map.get("repaymentType");//还款方式
        Double rate = (Double) map.get("repaymentRate");//还款利率
        Integer time =  Integer.parseInt((String)map.get("repaymentTime"));//还款期数
        Double money = Double.parseDouble((String) map.get("loanMoney"));//借款总金额
        Double allMoney=null;
        Double rateMoney=null;
        if ("等额本息".equals(type)){
            allMoney=AverageCapitalPlusInterestUtils.getPrincipalInterestCount(money, rate, time);//总金额
            rateMoney = AverageCapitalPlusInterestUtils.getInterestCount(money, rate, time);//总利息
        }
        if("等额本金".equals(type)){
            rateMoney = AverageCapitalUtils.getInterestCount(money, rate, time);//总利息
            allMoney=rateMoney+money;//总金额
        }
        maps.put("rateMoney",rateMoney);
        maps.put("allMoney",allMoney);
        return maps;
    }

    /**
     * 判断用户的借款资格
     * @param userLogin
     * @return
     */
    @Override
    public ResultUtil getBorrowQualification(UserLogin userLogin) {
        //查看用户是否完成认证
           String name= mapper.getCompanyQualification(userLogin);
        //查看用户是否借款
        List<Integer> loanId=mapper.getLoans(userLogin);
        List<Integer> reId=mapper.getRepayment(userLogin);
        //判断
      if (name!=null&&name!=""&&loanId.size()<=0&&reId.size()<=0){
          return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
      }
        return new ResultUtil(ResultUtil.CODE_FAIL,ResultUtil.MSG_FAIL,null);
    }

    /**
     * 获取用户的资金信息
     * @param userLogin
     * @return
     */
    @Override
    public Map<String, Object> getFund(UserLogin userLogin) {
        Map<String, Object> map = new HashMap<>();
        //查询用户账号资金信息
       double allMoney= mapper.getAllMoney(userLogin);
        //查询用户的借款信息
        double borrowMoney=mapper.getBorrowMoney(userLogin);
        //查询用户的剩余还款金额
        double repaymentMoney=mapper.repaymentMoney(userLogin);
        map.put("name",userLogin.getUsername());
        map.put("allMoney",allMoney);
        map.put("borrowMoney",borrowMoney);
        map.put("repaymentMoney",repaymentMoney);
        return map;
    }

    /**
     * 根据用户的资金类型查询相应的信息
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> getMoneyRecord(PageUtil page) {
        Map<String, Object> map = new HashMap<>();
        List<Map> fund=mapper.getMoneyRecord(page);
        Integer count=mapper.getFund(page);
        map.put("fundList",fund);
        map.put("count",count);
        return map;
    }

    /**
     * 更改用户的支付密码
     * @param map
     * @return
     */
    @Override
    public ResultUtil postPaypassword(Map map) {
        mapper.postPaypassword(map);
        return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
    }

    /**
     * 更改用户的登录密码
     * @param map
     * @return
     */
    @Override
    public ResultUtil postLoginPassword(Map map) {
        //获取盐值
        String salt = (String) map.get("passwordSalt");
        String telephone = (String) map.get("telephone");
        String newLoginPasswordOne = (String) map.get("newLoginPasswordOne");
        //md5加密获取加密后的密码
        String addMD5Password = MD5Util.addSaltMD5(telephone, newLoginPasswordOne, salt);
        map.put("addMD5Password",addMD5Password);
        mapper.postLoginPassword(map);
        return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
    }

}
