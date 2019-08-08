package com.aaa.ysemm.customer.service;

import com.aaa.ysemm.customer.entity.MingXi;

import java.util.List;
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
    int saveMingXi(Map mingXi);/**
     * 查询放款 生成 放款统计图 按周
     */
    Map queryLoan ();
    /**
     * 查询借款 生成 借款统计图 按周
     */
    Map queryBorrow();
    /**
     * 获取统计数据
     * @param map
     * @return
     */
    List<Map> getDataA(Map map);
    /**
     * 明细查询
     */
    List<Map> queryDetail(Map map);
    /**
     * 查询分页总数量
     *
     * @param map
     * @return
     */
    int queryDetailCount(Map map);
    /**
     * 删除明细表里面的本条记录
     * @param id
     * @return
     */
    int deleteRecord(Integer id);
    /**
     * 按年统计利润
     */
    List<Map> getProfit(Map map);
}
