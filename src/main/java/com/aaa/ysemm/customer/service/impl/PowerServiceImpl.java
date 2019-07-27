package com.aaa.ysemm.customer.service.impl;

import com.aaa.ysemm.customer.dao.PowerMapper;
import com.aaa.ysemm.customer.entity.TreeNode;
import com.aaa.ysemm.customer.service.PowerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.service.impl
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/20 9:17
 * @Version: 1.0
 */
@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerMapper powerMapper;

    /**
     * 获取所有的权限列表
     * @return
     */
    @Override
    public List<TreeNode> getPowerTreeData() {
        //获取列表
        List<TreeNode> powers = powerMapper.getPowers();
        //定义临时集合，用于存放拼装后的树的数据
        List<TreeNode> tmpTreeDate=new ArrayList<TreeNode>();
        //判断获取的权限列表是否为空
        if (powers!=null && powers.size()!=0){
            for (TreeNode power : powers) {
                //判断是否为一级节点
                if (power.getParentId()==0){
                    tmpTreeDate.add(power);
                    //查找子节点并绑定
                    bindChildren(power,powers);
                }
            }
        }
        return tmpTreeDate;
    }

    /**
     * 递归绑定子节点的过程
     * treeNode:当前节点
     * powers：所有权限的集合
     */
    private void bindChildren(TreeNode treeNode,List<TreeNode> powers){
        List<TreeNode> list=null;
        //循环遍历子节点
        for (TreeNode power : powers) {
            //如果父节点的id==子节点的父节点的id
            if (treeNode.getId()==power.getParentId()){
                List<TreeNode> childrens = treeNode.getChildren();
                //判断父节点下的子节点的是否为空
                if (childrens==null||childrens.size()==0){
                    //创建临时集合存储数据
                   list = new ArrayList<>();
                    //添加当前节点到临时集合
                    list.add(power);
                    treeNode.setChildren(list);
                }else{
                    childrens.add(power);
                }
                //递归调用查找子节点并绑定
                bindChildren(power,powers);
            }
        }
    }
}
