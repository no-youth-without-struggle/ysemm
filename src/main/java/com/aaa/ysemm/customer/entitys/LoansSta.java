package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  loans_sta
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class LoansSta{

	private int ssid;
	private int loansStatus;
	private String statusName;

}

