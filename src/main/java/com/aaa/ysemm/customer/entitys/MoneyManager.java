package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  money_manager
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class MoneyManager{

	private int id;
	private int totalMoney;
	private String operator;
	private int opertorId;
	private java.util.Date operatorTime;
	private String remark;

}

