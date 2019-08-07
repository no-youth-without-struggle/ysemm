package com.aaa.ysemm.manage.dao;
import com.aaa.ysemm.customer.entity.TreeNode;
import com.aaa.ysemm.entity.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import java.util.List;
import java.util.Map;

/**
 * fileName:LoginDao
 * description:
 * author:yangjunling
 * createTime:2019/7/28 15:05
 * version:1.0.0
 */

public interface LoginDao {


    /**
     * 用户注册
     */
    @Insert("insert into login(email,password) VALUES(#{email},#{password})")
    int saveReg(Login login);
    /**
     * 管理员登录
     * @return
     */
    @Select("select * from login where status=1 and email=#{email}")
    List<Map> queryLoginTWwo(Map map);


    @Select("SELECT l.lid,l.email,l.`password`,l.`status`,e.eid,e.ename,e.IDCard,e.telephone,e.birthday,e.sex,e.deptId,e.address,e.operator,e.operator_id operatorId,e.operator_time operatorTime,e.hiredate  from login l INNER JOIN employee e on l.lid=e.lid" +
            "    where l.email=#{email} and l.password=#{password} and l.status=1;")
    List<Login> getLogin(Map map);

    @Select(" select r.rid,r.rname from employee e INNER JOIN emp_role er on e.eid=er.eid INNER JOIN role r  on er.rid=r.rid where e.lid=#{lid}")
    List<Map> getRole(Login login);

    @Select("SELECT p.id,p.name label,p.parentid,p.url from role_per rp INNER JOIN permission p on p.id=rp.pid where rp.rid=#{rid}")
    List<TreeNode> getLoginMenu(Integer rid);
}
