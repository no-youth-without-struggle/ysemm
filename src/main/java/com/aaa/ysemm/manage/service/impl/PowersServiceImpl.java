package com.aaa.ysemm.manage.service.impl;



import com.aaa.ysemm.manage.dao.PowerDao;
import com.aaa.ysemm.manage.entity.Power;
import com.aaa.ysemm.manage.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * fileName:PowerServiceImpl
 * description:
 * author:yangjunling
 * createTime:2019/7/30 12:58
 * version:1.0.0
 */
@Service
public class PowersServiceImpl implements PowerService {

    @Autowired
    private PowerDao powerDao;
    @Override
    public List<Power> getPowerTreeData() {
        //获取列表
        List<Power> powers = powerDao.getPowers();
        //定义临时集合
        List<Power> tmpTreeData = new ArrayList<Power>();
        //判断
        if (powers != null && powers.size() > 0) {
            for (Power power : powers) {
                //判断是否是一级节点
                if (power.getParentId() == 0) {
                    tmpTreeData.add(power);
                    //查找孩子并且绑定
                    bindChildren(power,powers);
                }
            }
        }
        return tmpTreeData;
    }

    /**
     * 递归绑定下级权限过程
     *
     * @param treeNode
     * @param powers
     */
    private void bindChildren(Power treeNode, List<Power> powers) {
        List<Power> tmpChildrens = null;
//        treeNode=系统管理 .getId=1 系统配置 角色管理 权限管理
        for (Power power : powers) {
            //如果节点的父节点等于当前节点的 id，该节点就是当前节点的孩子节点
            if (treeNode.getId() == power.getParentId()) {
                List<Power> childrens = treeNode.getChildren();
                //天机第一个孩子时，要判断是否已经存在孩子
                if (childrens == null || childrens.size() == 0) {
                    tmpChildrens = new ArrayList<>();
                    tmpChildrens.add(power);
                    treeNode.setChildren(tmpChildrens);
                } else {
                    childrens.add(power);
                }
//                递归调用自己查找孩子并且绑定
                bindChildren(power, powers);
            }
        }
    }
}
