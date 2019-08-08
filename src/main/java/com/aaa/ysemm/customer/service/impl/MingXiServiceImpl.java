package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.MingXiMapper;
import com.aaa.ysemm.customer.entity.MingXi;
import com.aaa.ysemm.customer.service.MingXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:MingXiServiceImpl
 * description:
 * author:yangjunling
 * createTime:2019/8/1 10:41
 * version:1.0.0
 */
@Service
public class MingXiServiceImpl implements MingXiService {
    @Autowired
    private MingXiMapper mingXiMapper;
    @Override
    public int saveMingXi(Map mingXi) {
        System.out.println(mingXi+"sdsssssssss");
        String remark = (String) mingXi.get("nper");
        mingXi.put("type","还款");
        if (remark.equals("充值金额")){
            mingXi.put("type","充值");
        }
        if (remark.equals("提现金额")){
            mingXi.put("type","提现");
        }
        int i = mingXiMapper.saveMingXi(mingXi);
        return i;
    }

    @Override
    public Map queryLoan() {
        Map map = mingXiMapper.queryLoan();
        if (map!=null&&map.size()>0){
            return map;
        }
        return null;
    }

    @Override
    public Map queryBorrow() {
        Map map = mingXiMapper.queryBorrow();
        if (map!=null&&map.size()>0){
            return map;
        }
        return null;
    }

    @Override
    public List<Map> getDataA(Map map) {
        return mingXiMapper.getDataA(map);
    }

    @Override
    public List<Map> queryDetail(Map map) {
        List<Map> detail = mingXiMapper.queryDetail(map);
        if (detail!=null&&detail.size()>0){
            return detail;
        }
        return null;
    }

    @Override
    public int queryDetailCount(Map map) {
        return mingXiMapper.queryDetailCount(map);
    }

    @Override
    public int deleteRecord(Integer id) {
        return mingXiMapper.deleteRecord(id);
    }


}
