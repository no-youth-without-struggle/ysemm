package com.aaa.ysemm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.entity
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/19 20:30
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TreeNode {
    private Integer id;
    private String label;
    private Integer parentId;
    private String parentName;
    private List<TreeNode>  children;
    private String url;
    private String addUserName;
    private Integer addID;
    private String addTime;

}
