package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.MingXiMapper;
import com.aaa.ysemm.customer.entity.MingXi;
import com.aaa.ysemm.customer.service.MingXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return mingXiMapper.saveMingXi(mingXi);
    }
}
