package com.aaa.ysemm.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.entity
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/18 19:34
 * @Version: 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private String sex;
    private Integer deptno;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
    private String dname;
}
