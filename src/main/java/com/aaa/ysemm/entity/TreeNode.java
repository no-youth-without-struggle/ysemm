package com.aaa.ysemm.entity;

import java.util.List;

/**
 * @ProjectName: vue_demo
 * @Package: com.example.demo.entity
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/19 20:30
 * @Version: 1.0
 */
public class TreeNode {
    private Integer id;
    private String label;
    private Integer parentId;
    private List<TreeNode> children;
    private String url;
    private String addUsrName;
    private String addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddUsrName() {
        return addUsrName;
    }

    public void setAddUsrName(String addUsrName) {
        this.addUsrName = addUsrName;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                ", url='" + url + '\'' +
                ", addUsrName='" + addUsrName + '\'' +
                ", addTime='" + addTime + '\'' +
                '}';
    }
}
