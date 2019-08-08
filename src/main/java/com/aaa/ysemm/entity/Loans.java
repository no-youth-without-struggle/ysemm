package com.aaa.ysemm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * table name:  loans
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Loans {
	private int loanId;
	private int loanCid;
	private BigDecimal loanMoney;
	private String loanType;
	private int pledgeId;
	private String guarantorId;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
	private Date applyTime;
	private String auditorOne;
	private int auditorOneId;
	private Date auditorOneTime;
	private String auditorTwo;
	private int auditorTwoId;
	private Date auditorTwoTime;
	private int auditorResult;
	private String auditorReason;
	private String repaymentType;
	private int repaymentTime;
	private Double repaymentRate;
	private int loansStatus;
	private String loansSpareOne;
	private String loansSpareTwo;
	private int loansSpareThree;
	private BigDecimal countMoney;
	private BigDecimal rateMoney;

}

