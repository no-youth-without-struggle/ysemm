package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  pledge
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Pledge{

	private int id;
	private String pledgeName;
	private double valuation;
	private String pledgeType;
	private java.util.Date pledgeTime;
	private String description;

}

