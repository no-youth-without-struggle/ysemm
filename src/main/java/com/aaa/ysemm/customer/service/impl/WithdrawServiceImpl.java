package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.WithdrawMapper;
import com.aaa.ysemm.customer.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class WithdrawServiceImpl implements WithdrawService {
    @Autowired
    private WithdrawMapper withdrawMapper;
    //从登录的 session里面取出 用户表的 uid   查询出他的账户金额
    @Override
    public Map queryMoney(Integer uid) {
        return withdrawMapper.queryMoney(uid);
    }
    //充值金额
    @Override
    public int updateMoney(Map map) {
        return withdrawMapper.updateMoney(map);
    }
    //金额提现
    @Override
    public int deleteMoney(Map map) {
        return withdrawMapper.deleteMoney(map);
    }

    /**
     * 判断支付密码是否正确
     * @param map
     * @return
     */
    @Override
    public String getPayPassword(Map map) {
        return withdrawMapper.getPayPassword(map);
    }

}
