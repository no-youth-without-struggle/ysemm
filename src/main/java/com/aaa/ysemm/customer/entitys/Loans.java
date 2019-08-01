package com.aaa.ysemm.customer.entitys;

import java.util.Date;
/**
 * table name:  loans
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Loans{
	private int loanId;
	private int loanCid;
	private double loanMoney;
	private String loanType;
	private int pledgeId;
	private String guarantorId;
	private java.util.Date applyTime;
	private String auditorOne;
	private int auditorOneId;
	private java.util.Date auditorOneTime;
	private String auditorTwo;
	private int auditorTwoId;
	private java.util.Date auditorTwoTime;
	private int auditorResult;
	private String auditorReason;
	private String repaymentType;
	private int repaymentTime;
	private Double repaymentRate;
	private int loansStatus;
	private String loansSpareOne;
	private String loansSpareTwo;
	private int loansSpareThree;
	private Double countMoney;
	private Double rateMoney;

}

