package com.aaa.ysemm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.entity
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/19 9:08
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Page {
    private Integer start;
    private Integer count;
    private String ename;
    private Integer deptno;
}
