package com.aaa.ysemm.manage.dao;

import com.aaa.ysemm.manage.entity.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.dao
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/7 20:01
 * @Version: 1.0
 */
public interface SecondAuditMapper {
    List<Map<String, Object>> getCompany(PageUtil page);

    Integer getCount(PageUtil page);
}
