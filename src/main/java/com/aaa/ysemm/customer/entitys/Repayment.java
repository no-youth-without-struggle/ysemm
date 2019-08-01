package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  repayment
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Repayment{

	private int rid;
	private int lid;
	private double reMoney;
	private double reBalance;
	private int status;
	private String nper;
	private int uid;

}

