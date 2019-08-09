package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.WithdrawMapper;
import com.aaa.ysemm.customer.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:WithdrawServiceImpl
 * description:
 * author:yangjunling
 * createTime:2019/8/7 15:04
 * version:1.0.0
 */
@Service
public class WithdrawServiceImpl implements WithdrawService {
    @Autowired
    private WithdrawMapper withdrawMapper;
    @Override
    public Map queryMoney(Integer uid) {
        return withdrawMapper.queryMoney(uid);
    }

    @Override
    public int updateMoney(Map map) {
        return withdrawMapper.updateMoney(map);
    }

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
