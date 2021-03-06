package com.aaa.ysemm.manage.service.impl;

import com.aaa.ysemm.entity.Employee;
import com.aaa.ysemm.entity.Department;
import com.aaa.ysemm.entity.Role;
import com.aaa.ysemm.manage.dao.ManagerMapper;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.manage.service.ManagerService;
import com.aaa.ysemm.manage.service.RoleService;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.service.impl
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/3 16:40
 * @Version: 1.0
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private RoleService roleService;


    /**
     * 动态条件查询+分页
     */
    @Override
    public Map<String, Object> getEmp(PageUtil page) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //分页+搜索
        List<Map<String, Object>> emp = managerMapper.getEmp(page);
        //获取当前查询总数
        Integer count = managerMapper.getCount(page);

        hashMap.put("emp",emp);
        hashMap.put("count",count);
        return hashMap;
    }

    /**
     * 动态获取部门和角色菜单
     * @return
     */
    @Override
    public Map<String, Object> getMenu() {
        Map<String, Object> map = new HashMap<>();
        //获取部门菜单
        List<Department> dept=managerMapper.getDepartment();
        //获取角色菜单
        List<Role> role=managerMapper.getRole();
        map.put("dept",dept);
        map.put("role",role);
        return map;
    }

    /**
     * 添加人员信息
     * @param
     * @return
     */
    @Transactional
    @Override
    public ResultUtil postEmp(Employee employee) {
        //添加用户账号
         managerMapper.postLogin(employee);
        //获取操作用户的信息
        Employee emp=managerMapper.getEmptor(employee);
        employee.setOperatorId(emp.getLid());
        employee.setOperator(emp.getEname());
        employee.setOperatorTime(new Date());
        //添加用户的信息
        managerMapper.postEmp(employee);
        //添加角色信息
        if(employee.getRoleIds()!=null&&!"".equals(employee.getRoleIds())) {
            //解析roleid字符串
            String roleIds = employee.getRoleIds();
            String[] roleIdsArr = roleIds.split(",");
            //批量添加用户角色关联
            for (String roleId : roleIdsArr) {
                managerMapper.postRole(employee.getEid(), Integer.valueOf(roleId));
            }
        }
        return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,emp);
    }


    /**
     *修改 信息
     * @param map
     * @return
     */
    @Transactional
    @Override
    public ResultUtil updateEmp( Employee employee) {
        //修改人员信息表信息
         managerMapper.updateEmp(employee);
         //修改登录信息
            managerMapper.updateLogin(employee);
        //修改角色信息
        if(employee.getRoleIds()!=null&&!"".equals(employee.getRoleIds())) {
            //根据用户id删除该用户原来关联的角色id
            roleService.deleteRolesByUserId(employee.getEid());
            //解析roleid字符串
            String roleIds = employee.getRoleIds();
            String[] roleIdsArr = roleIds.split(",");
            //批量添加用户角色关联
            for (String roleId : roleIdsArr) {
                roleService.saveUserAndRole(employee.getEid(), Integer.valueOf(roleId));
            }
        }
            return new ResultUtil(ResultUtil.CODE_SUCCESS,ResultUtil.MSG_SUCCESS,null);
    }
}
