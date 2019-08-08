package com.aaa.ysemm.manage.controller;

import com.aaa.ysemm.entity.TreeNode;
import com.aaa.ysemm.manage.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.controller
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/7 9:56
 * @Version: 1.0
 */
@RestController
@RequestMapping("/Permission")
public class PermissionController {
    @Autowired
    private PermissionService service;

    /**
     * 获取权限菜单树数据
     * @return
     */
    @RequestMapping("/getTree")
    public Object tree(){
        return service.getPowerTreeData();
    }

    /**
     * 获取权限根据ID
     * @param powerId
     * @return
     */
    @RequestMapping("getPowerById")
    public Object getPowerById(Integer powerId){
        return service.getPowerById(powerId);
    }

    /**
     * 添加
     * @param treeNode
     * @return
     */
    @RequestMapping("save")
    public Object save(@RequestBody TreeNode treeNode, HttpSession session){
        return service.save(treeNode,session);
    }

    /**
     * 更新
     * @param treeNode
     * @return
     */
    @RequestMapping("update")
    public Object update(@RequestBody TreeNode treeNode){
        return service.update(treeNode);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public Object delete(Integer id){
        return service.delete(id);
    }
}
