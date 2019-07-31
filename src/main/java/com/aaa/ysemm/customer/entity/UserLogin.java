package com.aaa.ysemm.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.entity
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/28 17:25
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserLogin {
    private Integer uid;
    private String username;
    private String telephone;
    private String password;
    private  String passwordSalt;
    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date time;
    private String payPassword;
    private String phonecode;

}
