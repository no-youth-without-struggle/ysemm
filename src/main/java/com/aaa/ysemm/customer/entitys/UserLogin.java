package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  user_login
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class UserLogin{

	private int uid;
	private String username;
	private String telephone;
	private String password;
	private String passwordSalt;
	private int status;
	private java.util.Date time;
	private String payPassword;

}

