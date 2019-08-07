package com.aaa.ysemm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * table name:  login
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Login {
	private int lid;
	private String email;
	private String password;
	private int status;
	private Date currentTime;
	private String IDCard;
	private Integer rId;
	private int eid;
	private String ename;
	private String telephone;
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	private String sex;
	private int deptId;
	private String operator;
	private Integer operatorId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date operatorTime;
	private String address;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private  Date hiredate;

	

}

