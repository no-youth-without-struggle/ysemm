package com.aaa.ysemm.manage.service;

import com.aaa.ysemm.entity.TreeNode;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.service
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/7 9:58
 * @Version: 1.0
 */
public interface PermissionService {
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

}
