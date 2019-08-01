package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  permission
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Permission{

	private int id;
	private String name;
	private int parentid;
	private String url;
	private String operator;
	private java.util.Date operatorTime;
	private int operatorId;

}

