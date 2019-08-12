package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.manage.dao.FkMapper;
import com.aaa.ysemm.manage.service.FkService;
import com.aaa.ysemm.util.AverageCapitalPlusInterestUtils;
import com.aaa.ysemm.util.AverageCapitalUtils;
import com.aaa.ysemm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FkServiceImpl implements FkService {
    @Autowired
    FkMapper fkMapper;
    @Override
    public List<Map> queryFK() {

        return fkMapper.queryFK();
    }
    public List<Map> queryZj() {

        return fkMapper.queryZj();
    }

    /**
     * 放款操作
     * @param
     * @return
     */
    @Transactional
    @Override
    public Map loanMoney(Integer cid) {
        //根据借款id获取用户借款信息
        Map map = fkMapper.getLoan(cid);
        String repaymentType = (String) map.get("repaymentType");//还款类型
        String type = (String) map.get("loanType");//贷款类型
        Integer loanCid = (Integer) map.get("loanCid");//贷款公司id
        BigDecimal money = (BigDecimal) map.get("loanMoney");//贷款总金额
        Integer time = (Integer) map.get("repaymentTime");  //贷款期数
        Double rate = (Double) map.get("repaymentRate");//贷款利率
        String cname = (String) map.get("cname");
        Date times = new Date();
        //进行放款
        fkMapper.updateMoney(money);//更改总资金池
        fkMapper.updateComMoney(map);//更改用户钱数
        map.put("times", times);
        fkMapper.insertNodes(map);//添加详细数据记录
        fkMapper.updateLoans(cid);//修改借款状态为还款中

        Map hashMap = new HashMap();
        //判断还款的类型
        if ("等额本息".equals(repaymentType)) {
            double dmoney = money.doubleValue();
            //等额本息还款:每月偿还本金和利息
            double perMonthPrincipalInterest = AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterest(dmoney, rate, time);
            BigDecimal bigDecimal = BigDecimal.valueOf(perMonthPrincipalInterest);
            //每月还款的本金
            Map<Integer, BigDecimal> decimalMap = AverageCapitalPlusInterestUtils.getPerMonthPrincipal(dmoney, rate, time);
            //每月还款的利息
            Map<Integer, BigDecimal> AverageCapitalPlusInterest = AverageCapitalPlusInterestUtils.getPerMonthInterest(dmoney, rate, time);
            BigDecimal decimal = new BigDecimal(0);
            for (int i = 0; i < time; i++) {
                decimal=decimal.add(decimalMap.get(i + 1));
                System.out.println(i+":"+decimal);
                BigDecimal number = BigDecimal.valueOf(i + 1);
                hashMap.put("lid", cid);
                hashMap.put("reMoney", bigDecimal);
                hashMap.put("reBalance", money.subtract(decimal));//multiply:乘法，subtract：减法
                hashMap.put("nper", i + 1 + "期");
                hashMap.put("toTime", DateUtil.addDate(DateUtil.Month, i + 1));
                hashMap.put("reRateMoney", AverageCapitalPlusInterest.get(i + 1).doubleValue());
                fkMapper.insertRepayment(hashMap);
            }

        }

        if ("等额本金".equals(repaymentType)) {
            double dmoney = money.doubleValue();
            //每期还款本金+利息的钱数集合
            Map<Integer, Double> monthMoney = AverageCapitalUtils.getPerMonthPrincipalInterest(dmoney, rate, time);
            //每月还款本金
            double perMonthPrincipal = AverageCapitalUtils.getPerMonthPrincipal(dmoney, time);
            BigDecimal perMonth = BigDecimal.valueOf(perMonthPrincipal);
            //每月还款利息
            Map<Integer, Double> perMonthInterest = AverageCapitalUtils.getPerMonthInterest(dmoney, rate, time);
            for (int i = 0; i < time; i++) {
                BigDecimal number = BigDecimal.valueOf(i + 1);
                hashMap.put("lid", cid);
                hashMap.put("reMoney", monthMoney.get(i + 1));
                hashMap.put("reBalance", money.subtract(perMonth.multiply(number)));//multiply:乘法，subtract：减法
                hashMap.put("nper", i + 1 + "期");
                hashMap.put("toTime", DateUtil.addDate(DateUtil.Month, i + 1));
                hashMap.put("reRateMoney", perMonthInterest.get(i + 1));
                fkMapper.insertRepayment(hashMap);
            }

        }
        HashMap<String, String> maps = new HashMap<>();
        maps.put("result", "成功");
        return maps;
    }

}
