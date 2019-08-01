package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  employee
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Employee{

	private int eid;
	private int lid;
	private String ename;
	private String IDCard;
	private String telephone;
	private String email;
	private java.util.Date birthday;
	private String sex;
	private int deptId;
	private int status;
	private String operator;
	private String operatorId;
	private java.util.Date operatorTime;

}

