package com.aaa.ysemm.customer.service;

import com.aaa.ysemm.customer.entity.TreeNode;


import java.util.List;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.service
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/20 9:15
 * @Version: 1.0
 */
public interface PowerService {
    /**
     * 获取所有的权限
     * @return
     */
    List<TreeNode> getPowerTreeData();
}
