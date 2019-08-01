package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  role
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Role{

	private int rId;
	private String rname;
	private String operator;
	private int operatorId;
	private java.util.Date operatorTime;

}

