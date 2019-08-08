package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.entity.Login;
import com.aaa.ysemm.entity.TreeNode;
import com.aaa.ysemm.manage.dao.RoleDao;
import com.aaa.ysemm.manage.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * fileName:PowerServiceImpl
 * description:
 * author:zz
 * createTime:2019/7/19 16:41
 * versoin:1.0.0
 */
@Service
@Transactional
@SuppressWarnings("all")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<TreeNode> getPowerTreeData() {
        //获取列表
        List<TreeNode> powers = roleDao.getPowers();
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
        List<TreeNode> powerList = roleDao.getPowerById(powerId);
        if(powerList!=null&&powerList.size()>0){
            return powerList.get(0);
        }
        return null;
    }


    @Override
    public int save(TreeNode treeNode,HttpSession session) {
       // treeNode.setAddUserName(((Map)session.getAttribute("emp")).get("username")+"");
        Login login = (Login) session.getAttribute("login");
        String nodeIds = treeNode.getUrl();//1,7,8,2,9,10
        String[] nodeIdsArr = nodeIds.split(",");
        System.out.println("................selectKey赋值之前:" +treeNode.getId());
        //保存新加的角色信息，并且返回该角色id
        int result = roleDao.save(treeNode);
        //System.out.println(1/0);
        System.out.println("................自增后的ID为:"+result+","+  treeNode.getId());
        //为新角色添加关联
        for (String nodeId : nodeIdsArr) {
            roleDao.saveRoleAndPower(Integer.valueOf(nodeId),treeNode.getId());
        }
        return result;
    }

    @Override
    public int update(TreeNode treeNode) {
        String nodeIds = treeNode.getUrl();//1,7,8,2,9,10
        String[] nodeIdsArr = nodeIds.split(",");
        //treeNode.getId() 获取当前角色id
        //删除原来该角色关联的所有权限
        roleDao.deletePowersByRoleId(treeNode.getId());
        //保存角色信息
       int i=  roleDao.update(treeNode);
       //添加新的关联
        for (String nodeId : nodeIdsArr) {
            roleDao.saveRoleAndPower(Integer.valueOf(nodeId),treeNode.getId());
        }
        return i;
    }

    @Override
    public int delete(int id) {
        return roleDao.delete(id);
    }

    @Override
    public List<Integer> getPowersByRoleId(int roleId) {
        return roleDao.getPowersByRoleId(roleId);
    }


    @Override
    public int deleteRolesByUserId(int userId) {
        return roleDao.deleteRolesByUserId(userId);
    }

    @Override
    public List<Integer> getRolesByUserId(int userId) {
            return roleDao.getRolesByUserId(userId);
    }
    @Override
    public int saveUserAndRole(int userId, int roleId) {
        return roleDao.saveUserAndRole(userId,roleId);
    }
}
