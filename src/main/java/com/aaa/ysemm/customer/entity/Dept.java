package com.aaa.ysemm.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.entity
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/18 20:13
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Dept {
    private Integer deptno;
    private String dname;
}
