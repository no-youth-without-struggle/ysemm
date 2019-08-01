package com.aaa.ysemm.customer.dao;

import com.aaa.ysemm.customer.entity.MingXi;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * fileName:MingXiMapper
 * description:
 * author:yangjunling
 * createTime:2019/8/1 10:36
 * version:1.0.0
 */
@Repository
public interface MingXiMapper {
    /**
     * 保存还款数据到 明细表里面
     * @param mingXi
     * @return
     */
    int saveMingXi(Map mingXi);
}
