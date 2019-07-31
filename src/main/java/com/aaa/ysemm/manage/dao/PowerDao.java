package com.aaa.ysemm.manage.dao;

import com.aaa.ysemm.manage.entity.Power;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * fileName:PowerDao
 * description:
 * author:yangjunling
 * createTime:2019/7/30 12:52
 * version:1.0.0
 */
@Repository
public interface PowerDao {
    /**
     *
     *遍历显示子菜单
     * @return
     */
    @Select("select id,name as label,parentid as parentId,url,operator,operator_time as operatorTime,operator_id as operatorId  from permission")
    List<Power> getPowers();
}
