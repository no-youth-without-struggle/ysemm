package com.aaa.ysemm.customer.dao;

import com.aaa.ysemm.customer.entity.TreeNode;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.mapper
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/20 9:11
 * @Version: 1.0
 */
@Repository
public interface PowerMapper {

    @Select("select id,name as label,parentid,url,add_username addUserName,add_time addTime from tb_power")
    List<TreeNode> getPowers();
}
