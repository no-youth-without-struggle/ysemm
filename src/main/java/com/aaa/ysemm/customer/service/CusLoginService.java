package com.aaa.ysemm.customer.service;
import com.aaa.ysemm.entity.UserLogin;
import com.aaa.ysemm.util.ResultUtil;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.service
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/28 16:28
 * @Version: 1.0
 */
public interface CusLoginService {
    //判断电话是否重复
    ResultUtil getTelehone(String telephone);
    //录入用户登录信息
    ResultUtil postForm(UserLogin userLogin);
    //判断用户是否登录
    UserLogin getSubmitLoin(Map map);
}
