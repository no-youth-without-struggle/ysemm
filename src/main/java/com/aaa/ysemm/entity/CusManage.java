package com.aaa.ysemm.entity;

import java.sql.Date;

/**
 * fileName:CusManage
 * description:
 * author:yangjunling
 * createTime:2019/8/1 16:32
 * version:1.0.0
 */
public class CusManage {
    private Integer uid;
    private Double totalMoney;
    private String operator;
    private Date operatorTime;
    private String remark;
    private Integer operatorId;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
