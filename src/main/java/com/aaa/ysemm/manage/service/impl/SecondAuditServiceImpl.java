package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.entity.Login;
import com.aaa.ysemm.manage.dao.SecondAuditMapper;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.manage.service.SecondAuditService;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    /**
     * 搜索+分页查询所有待二审的信息
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> getCompany(PageUtil page) {
        Map<String, Object> map = new HashMap<>();
        List< Map<String, Object>> borrow=mapper.getCompany(page);
        Integer count=mapper.getCount(page);
        map.put("borrow",borrow);
        map.put("count",count);
        return map;
    }

    /**
     *通过
     * @param map
     * @param login
     * @return
     */
    @Override
    public ResultUtil handleSuccess(Map map, Login login) {
        map.put("operator",login.getEname());
        map.put("operatorid",login.getLid());
        map.put("operatorTime",new Date());
        map.put("loansType",2);
        int code=mapper.handleSuccess(map);
        if (code==0){
            return new ResultUtil(ResultUtil.CODE_FAIL,ResultUtil.MSG_FAIL,null);
        }
        return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
    }

    /**
     * 驳回
     * @param map
     * @param login
     * @return
     */
    @Override
    public ResultUtil handleFail(Map map, Login login) {
        map.put("operator",login.getEname());
        map.put("operatorid",login.getLid());
        map.put("operatorTime",new Date());
        map.put("loansType",3);
        int code=mapper.handleFail(map);
        if (code==0){
            return new ResultUtil(ResultUtil.CODE_FAIL,ResultUtil.MSG_FAIL,null);
        }
        return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
    }
}
