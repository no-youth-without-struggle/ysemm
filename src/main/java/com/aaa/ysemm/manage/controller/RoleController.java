package com.aaa.ysemm.manage.controller;

import com.aaa.ysemm.entity.TreeNode;
import com.aaa.ysemm.manage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * fileName:PowerController
 * description:
 * author:zz
 * createTime:2019/7/19 17:08
 * versoin:1.0.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色角色菜单树数据
     * @return
     */
    @RequestMapping("/tree")
    public Object tree(){
        return roleService.getPowerTreeData();
    }

    /**
     * 获取角色根据ID
     * @param powerId
     * @return
     */
    @RequestMapping("/getPowerById")
    public Object getPowerById(Integer powerId){
        return roleService.getPowerById(powerId);
    }

    /**
     * 添加
     * @param treeNode
     * @return
     */
    @RequestMapping("/save")
     public Object save(@RequestBody TreeNode treeNode, HttpSession session){
         return roleService.save(treeNode,session);
     }

    /**
     * 更新
     * @param treeNode
     * @return
     */
    @RequestMapping("/update")
     public Object update(@RequestBody TreeNode treeNode){
        return roleService.update(treeNode);
     }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
     public Object delete(Integer id){
           return roleService.delete(id);
     }

    /**
     * 根据角色ID查询以前该角色关联的所有权限
     * @param roleId
     * @return
     */
     @RequestMapping("/getPowersByRoleId")
    public Object getPowersByRoleId(Integer roleId){
         return roleService.getPowersByRoleId(roleId);
     }
}
