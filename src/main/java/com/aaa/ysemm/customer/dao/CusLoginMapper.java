package com.aaa.ysemm.customer.dao;

import com.aaa.ysemm.entity.UserLogin;
import org.springframework.stereotype.Repository;
import java.util.Map;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.dao
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/28 16:29
 * @Version: 1.0
 */
@Repository
public interface CusLoginMapper {

    Integer getTelephone(String telephone);

    int postForm(UserLogin userLogin);

    UserLogin getSubmitLoin(Map map);

    void postCusFund(UserLogin userLogin);
}
