package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.manage.dao.SecondAuditMapper;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.manage.service.SecondAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.service.impl
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/7 20:00
 * @Version: 1.0
 */
@Service
public class SecondAuditServiceImpl implements SecondAuditService {
    @Autowired
    private SecondAuditMapper mapper;
    @Override
    public Map<String, Object> getCompany(PageUtil page) {
        Map<String, Object> map = new HashMap<>();
        List< Map<String, Object>> borrow=mapper.getCompany(page);
        Integer count=mapper.getCount(page);
        map.put("borrow",borrow);
        map.put("count",count);
        return map;
    }
}
