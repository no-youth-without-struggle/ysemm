package com.aaa.ysemm.manage.service;

import com.aaa.ysemm.manage.entity.Power;

import java.util.List;

/**
 * fileName:PowerService
 * description:
 * author:yangjunling
 * createTime:2019/7/30 12:57
 * version:1.0.0
 */
public interface PowerService {
    /**
     * 遍历显示子菜单
     * @return
     */
    List<Power> getPowerTreeData();
}
