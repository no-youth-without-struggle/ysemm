package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  dictionary
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Dictionary{

	private int id;
	private String tableName;
	private String lineName;
	private String dname;

}

