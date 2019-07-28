package com.aaa.ysemm.manage.dao;

import com.aaa.ysemm.customer.entity.Emp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.dao
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/28 14:58
 * @Version: 1.0
 */
public interface EmpLogin {
    @Select("")
    List<Emp> getEmp();
}
