package com.aaa.ysemm.manage.service;

import com.aaa.ysemm.entity.TreeNode;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * fileName:PowerService
 * description:
 * author:zz
 * createTime:2019/7/19 16:40
 * versoin:1.0.0
 */
public interface RoleService {
    /**
     * 获取所有权限
     * @return
     */
    List<TreeNode> getPowerTreeData();

    /**
     * 根据id查询
     * @param powerId
     * @return
     */
    TreeNode getPowerById(int powerId);

    /**
     * 添加
     * @param treeNode
     * @param session
     * @return
     */
    int save(TreeNode treeNode, HttpSession session);

    /**
     * 更新
     * @param treeNode
     * @return
     */
    int update(TreeNode treeNode);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(int id);
    /**
     * 根据角色ID查询以前该角色关联的所有权限
     * @param roleId
     * @return
     */
    List<Integer> getPowersByRoleId(int roleId);
    /**
     * 根据用户ID删除以前该用户关联的所有角色
     * @param userId
     * @return
     */
    int deleteRolesByUserId(int userId);
    /**
     * 根据用户ID获取所有角色
     * @param userId
     * @return
     */
    List<Integer> getRolesByUserId(int userId);

    /**
     * 批量添加用户和角色关联表
     * @param userId
     * @param roleId
     * @return
     */
    int saveUserAndRole(int userId,int roleId);
}
