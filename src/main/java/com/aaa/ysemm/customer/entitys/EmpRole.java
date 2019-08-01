package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  emp_role
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class EmpRole{

	private int id;
	private int eId;
	private int rId;
	private String operator;
	private int opeartorId;
	private java.util.Date operatorTime;

}

