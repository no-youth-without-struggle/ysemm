package com.aaa.ysemm.manage.dao;

import com.aaa.ysemm.entity.Employee;
import com.aaa.ysemm.entity.Department;
import com.aaa.ysemm.entity.Role;
import com.aaa.ysemm.manage.entity.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.dao
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/3 16:40
 * @Version: 1.0
 */
public interface ManagerMapper {
    List<Map<String,Object>> getEmp(PageUtil page);
    Integer getCount(PageUtil page);

    List<Department> getDepartment();

    List<Role> getRole();

    int postLogin(Employee map);

    void postEmp(Employee map);

    Employee getEmptor(Employee map);

    void postRole(Employee employee);

    Map<String, Object> postUpdateEmp(Integer eid);
}
