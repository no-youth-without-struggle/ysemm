package com.aaa.ysemm.customer.dao;

import com.aaa.ysemm.customer.entity.MingXi;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
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
/*    int saveMingXi(Map mingXi);*/
    int saveMingXi(Map mingXi);
    /**
     * 查询放款 生成 放款统计图 按周
     */
    @Select("select DATE_FORMAT(operator_time,'%Y%u') weeks,count(cm_id) count ,SUM(pay_money)\n" +
            "from mingxi where pay_type='放款'  group by weeks;")
    Map queryLoan ();
    /**
     * 查询借款 生成 借款统计图 按周
     */
    @Select("select DATE_FORMAT(operator_time,'%Y%u') weeks,count(cm_id) count ,SUM(pay_money)\n" +
            "from mingxi where pay_type='还款'  group by weeks;")
    Map queryBorrow();

    /**
     * 获取统计数据
     * @param map
     * @return
     */
    @Select("<script>select <if test='month!=null and month!=0'> date_format(t.operator_time,'%m-%d') </if>  <if test='month==null or month==0'> date_format(t.operator_time,'%Y-%m') </if> as months,ifnull(sum(case when pay_type='还款' then pay_money end),0) hk,ifnull(sum(case when pay_type='放款' then pay_money end),0) fk from mingxi t " +
            "where  date_format(t.operator_time,'%Y')=#{year}" +
            "<if test='month!=null and month!=0'> and date_format(t.operator_time, '%m')=#{month} </if>"+
            " group by <if test='month!=null and month!=0'> date_format(t.operator_time,'%m-%d') </if>  <if test='month==null or month==0'> date_format(t.operator_time,'%Y-%m')</if>" +
            " order by  <if test='month!=null and month!=0'> date_format(t.operator_time,'%m-%d') </if>  <if test='month==null or month==0'> date_format(t.operator_time,'%Y-%m')</if></script>")
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
    @Update("update mingxi set STATUS=1 where id=#{id}")
    int deleteRecord(Integer id);
}
