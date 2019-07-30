package com.aaa.ysemm.manage.entity;

import java.sql.Date;
import java.util.List;

/**
 * fileName:Power
 * description:
 * author:yangjunling
 * createTime:2019/7/30 12:49
 * version:1.0.0
 */
public class Power {
    private Integer id;
    private String label;
    private Integer parentId;
    private String url;
    private List<Power> children;
    private String operator;
    private Date operatorTime;
    private Integer operatorId;

    public List<Power> getChildren() {
        return children;
    }

    public void setChildren(List<Power> children) {
        this.children = children;
    }

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

    public void setParentId(Integer paremtId) {
        this.parentId = paremtId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }


}
