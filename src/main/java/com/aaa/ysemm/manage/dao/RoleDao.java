package com.aaa.ysemm.manage.dao;

import com.aaa.ysemm.entity.TreeNode;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * fileName:PowerDao
 * description:
 * author:zz
 * createTime:2019/7/19 16:37
 * versoin:1.0.0
 */
@Repository
public interface RoleDao {

    /**
     * 获取所有角色
     * @return
     */
    @Select("select id,name as label,parentid,add_username addUserName,add_time addTime   from tb_role")
    List<TreeNode> getPowers();

       /**
     * 根据id查询
     * @param roleId
     * @return
     */
    @Select("select id,name as label,parentid,add_username addUserName,add_time addTime    from tb_role where id=#{powerId}")
    List<TreeNode> getPowerById(int roleId);


    /**
     * 添加
     * @param treeNode
     * @return
     */
    @SelectKey(statement = "select last_insert_id()",keyProperty = "id",before = false,resultType = int.class)
    @Insert("insert into tb_role(name,parentid,add_time,add_username) values(#{label},#{parentId},now(),#{addUserName})")
    int save(TreeNode treeNode);

    /**
     * 更新
     * @param treeNode
     * @return
     */
    @Update("update tb_role set name=#{label},parentId =#{parentId} where id=#{id}")
    int update(TreeNode treeNode);

    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from tb_role where id=#{id}")
    int delete(int id);

    /**
     * 向关联表添加数据
     * @param powerId
     * @param roleId
     * @return
     */
    @Insert("insert into tb_role_power values(null,#{roleId},#{powerId})")
    int saveRoleAndPower(@Param("powerId") int powerId, @Param("roleId") int roleId);

    /**
     * 根据角色ID删除以前该角色关联的所有权限
     * @param roleId
     * @return
     */
    @Delete("delete from tb_role_power where role_id=#{roleId}")
    int deletePowersByRoleId(int roleId);

    /**
     * 根据角色ID查询以前该角色关联的所有权限
     * @param roleId
     * @return
     */
    @Select("select power_id from tb_role_power where role_id=#{roleId}")
    List<Integer> getPowersByRoleId(int roleId);
}
