package com.aaa.ysemm.manage.controller;
import com.aaa.ysemm.entity.Employee;
import com.aaa.ysemm.entity.Login;
import com.aaa.ysemm.manage.entity.PageUtil;
import com.aaa.ysemm.manage.service.ManagerService;
import com.aaa.ysemm.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.manage.controller
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/8/3 16:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("/manage")
public class ManagerController {

    @Autowired
    private ManagerService service;

    /**
     * 分页+搜索
     * @param page
     * @return
     */
    @RequestMapping("/getEmp")
    public Map<String,Object> getEmp(@RequestBody PageUtil page){
        return service.getEmp(page);
    }
    /**
     * 动态获取下拉菜单
     */
    @RequestMapping("/getMenu")
    public Map<String,Object> getMenu(){
        return  service.getMenu();
    }

    /**
     * 添加人员信息
     */
    @RequestMapping("/postEmp")
    public ResultUtil postEmp(@RequestBody Employee employee, HttpSession session){
        Login login = (Login) session.getAttribute("login");
        employee.setOperatorId(login.getLid());
        ResultUtil resultUtil = service.postEmp(employee);
        Employee operator = (Employee) resultUtil.getObj();
        session.setAttribute("operator",operator);//将操作人员信息存到session中
        return resultUtil;
    }
    /**
     * 获取修改人员的信息
     */
    @RequestMapping("/postUpdateEmp")
    public Map<String,Object> postUpdateEmp(Integer eid){
        return service.postUpdateEmp(eid);
    }



}
