package com.aaa.ysemm.customer.service;

import com.aaa.ysemm.customer.entity.MingXi;

import java.util.Map;

/**
 * fileName:MingXiService
 * description:
 * author:yangjunling
 * createTime:2019/8/1 10:41
 * version:1.0.0
 */
public interface MingXiService {
    /**
     * 保存还款数据到 明细表里面
     * @param mingXi
     * @return
     */
    int saveMingXi(Map mingXi);
}
