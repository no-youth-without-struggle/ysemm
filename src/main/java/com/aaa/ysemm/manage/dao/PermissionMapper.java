package com.aaa.ysemm.manage.dao;

import com.aaa.ysemm.entity.TreeNode;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.dao
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/7 9:58
 * @Version: 1.0
 */
public interface PermissionMapper {

    /**
     * 获取所有权限
     * @return
     */
    @Select("select id,name as label,parentid,url,operator addUserName,operator_time addTime   from permission")
    List<TreeNode> getPowers();

    /**
     * 根据id查询
     * @param powerId
     * @return
     */
    @Select("select id,name as label,parentid,url,operator addUserName,operator_time addTime   from permission where id=#{powerId}")
    List<TreeNode> getPowerById(int powerId);


    /**
     * 添加
     * @param treeNode
     * @return
     */
    @Insert("insert into permission values(null,#{label},#{parentId},#{url},#{addUserName},now(),#{addID})")
    int save(TreeNode treeNode);

    /**
     * 更新
     * @param treeNode
     * @return
     */
    @Update("update permission set name=#{label},parentId =#{parentId},url=#{url} where id=#{id}")
    int update(TreeNode treeNode);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from permission where id=#{id}")
    int delete(int id);
}
