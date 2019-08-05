package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  login
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Login{

	private int lid;
	private String email;
	private String password;
	private int status;
	private java.util.Date currentTime;


}

