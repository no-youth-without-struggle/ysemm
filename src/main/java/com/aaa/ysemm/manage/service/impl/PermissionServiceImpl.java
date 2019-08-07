package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.entity.Login;
import com.aaa.ysemm.entity.TreeNode;
import com.aaa.ysemm.manage.dao.PermissionMapper;
import com.aaa.ysemm.manage.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.service.impl
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/7 9:59
 * @Version: 1.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper mapper;


    public List<TreeNode> getPowerTreeData() {
        //获取列表
        List<TreeNode> powers = mapper.getPowers();
        //定义临时集合，用于存放拼装后的树数据
        List<TreeNode> tmpTreeData = new ArrayList<TreeNode>();
        //判断
        if(powers!=null&&powers.size()>0){
            for (TreeNode power : powers) {
                //判断是否是一级节点
                if(power.getParentId()==0){
                    power.setParentName("根节点");
                    tmpTreeData.add(power);
                    //查找孩子并且绑定
                    bindChildren(power,powers);
                }
            }
        }
        return tmpTreeData;
    }

    /**
     * 递归绑定孩子过程
     * @param treeNode
     * @param powers
     */
    private void bindChildren(TreeNode treeNode,List<TreeNode> powers){
        List<TreeNode>  tmpChildrens = null;
        //treeNode=系统管理  .getId() =1  系统配置 角色管理 权限管理
        for (TreeNode power : powers) {
            if(treeNode.getId()==power.getParentId()){//如果节点的父节点等于当前节点的id,该节点就是当前节点的孩子
                power.setParentName(treeNode.getLabel());
                List<TreeNode> childrens = treeNode.getChildren();
                //添加第一个孩子时,要判断是否已经存在孩子
                if(childrens==null||childrens.size()==0){
                    tmpChildrens = new ArrayList<>();
                    tmpChildrens.add(power);
                    treeNode.setChildren(tmpChildrens);
                }else{
                    childrens.add(power);
                }
                //递归调用自己查找孩子并且绑定
                bindChildren(power,powers);
            }
        }

    }

    @Override
    public TreeNode getPowerById(int powerId) {
        List<TreeNode> powerList = mapper.getPowerById(powerId);
        if(powerList!=null&&powerList.size()>0){
            return powerList.get(0);
        }
        return null;
    }

    @Override
    public int save(TreeNode treeNode, HttpSession session) {
        Login login = (Login) session.getAttribute("login");
        treeNode.setAddUserName(login.getEname());
        treeNode.setAddID(login.getEid());
        return mapper.save(treeNode);
    }

    @Override
    public int update(TreeNode treeNode) {
        return mapper.update(treeNode);
    }

    @Override
    public int delete(int id) {
        return mapper.delete(id);
    }

}
