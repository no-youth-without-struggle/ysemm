package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  customer_manager
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class CustomerManager{

	private int id;
	private int uid;
	private double totalMoney;
	private String operator;
	private java.util.Date operatorTime;
	private String remark;
	private int operatorId;

}

