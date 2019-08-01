package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  mingxi
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Mingxi{

	private int id;
	private int cmId;
	private int mmId;
	private String payType;
	private double payMoney;
	private String operator;
	private java.util.Date operatorTime;
	private String remark;

}

