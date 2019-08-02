package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.HomeMapper;
import com.aaa.ysemm.customer.entity.UserLogin;
import com.aaa.ysemm.customer.entitys.Company;
import com.aaa.ysemm.customer.entitys.Loans;
import com.aaa.ysemm.customer.entitys.Pledge;
import com.aaa.ysemm.customer.service.HomeService;
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

}
