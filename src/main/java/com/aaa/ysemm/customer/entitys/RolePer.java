package com.aaa.ysemm.customer.entitys;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * table name:  role_per
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class RolePer{
	private int id;
	private int rid;
	private int pid;
	private String operator;
	private int operatorId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:SS")
	private java.util.Date operatorTime;
}

