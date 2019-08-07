package com.aaa.ysemm.customer.entity;

import java.util.Date;

/**
 * table name:  company
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Company {

	private int cid;
	private int uid;
	private String cname;
	private String pname;
	private String email;
	private String IDCard;
	private String telephone;
	private String phone;
	private String sex;
	private String businessLicense;
	private String nature;
	private String address;
	private int clientId;
	private String clientName;
	private Date clientTime;
	private int clientStatus;
	private int bankCard;
	private String bankType;
	private String faceIDCard;
	private String reverseIDCard;

}

