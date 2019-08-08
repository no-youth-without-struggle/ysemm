package com.aaa.ysemm.manage.dao;
import com.aaa.ysemm.customer.entity.TreeNode;
import com.aaa.ysemm.entity.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


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

    @Select("select p.id,p.`name` label,p.parentid parentId,p.url,p.operator addUsrName,p.operator_time addTime from\n" +
            "permission p join tb_role_power rp on p.id=rp.power_id\n" +
            "join tb_user_role ur on ur.role_id=rp.role_id\n" +
            "where ur.user_id=(SELECT eid from employee where lid=#{rid} );")
    List<TreeNode> getLoginMenu(Integer rid);
}
