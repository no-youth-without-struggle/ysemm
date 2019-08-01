package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  guarantor
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Guarantor{

	private int gid;
	private String gname;
	private String sex;
	private String IDCard;
	private String job;
	private String position;
	private String telephone;
	private String address;
	private double income;

}

