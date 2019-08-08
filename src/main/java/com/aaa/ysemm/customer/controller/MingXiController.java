package com.aaa.ysemm.customer.controller;

import com.aaa.ysemm.customer.service.MingXiService;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * fileName:MingXiController
 * description:
 * author:yangjunling
 * createTime:2019/8/2 16:00
 * version:1.0.0
 */
@RestController
@RequestMapping("mingxi")
public class MingXiController {
    @Autowired
    private MingXiService mingXiService;

    /**
     * 放款统计 按周
     * @return
     */
    @RequestMapping("fk")
    public Map queryLoan(){
        return mingXiService.queryLoan();
    }
    /**
     * 借款统计 按周
     * @return
     */
    @RequestMapping("jk")
    public Map queryBorrow(){
        return mingXiService.queryBorrow();
    }
    /**
     * 返回展示数据
     * @return
     */
    @RequestMapping("getDataA")
    public Object getEchartDataA(@RequestParam Map mapParam)
    {
        return  mingXiService.getDataA(mapParam);
    }
    /**
     *
     *明细查询
     */
    @RequestMapping("queryDetale")
    public Object queryDetail(@RequestBody Map map){
        //分页查询
        Map mapResult = new HashMap();
        mapResult.put("detail",mingXiService.queryDetail(map));
        mapResult.put("total", mingXiService.queryDetailCount(map));
        return mapResult;
    }
    /**
     * 删除明细表里面的记录信息
     */
    @RequestMapping("deleteRecord")
    public ResultUtil deleteRecord(Integer id){
        System.out.println(id+"打说扫所所所所所所所所所");
        int i = mingXiService.deleteRecord(id);
        if (i==1){
            return new ResultUtil(200,"成功",null);
        }
        return new ResultUtil(400,"失败",null);
    }
    /**
     * 按年统计利润
     */
    @RequestMapping("profit")
    public List<Map> getProfit(@RequestParam Map map){
        return mingXiService.getProfit(map);
    }
}
