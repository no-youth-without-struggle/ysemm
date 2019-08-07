package com.aaa.ysemm.entity;


import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

/**
 * table name:  login
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */
public class Login {
	private int lid;
	private String email;
	private String password;
	private int status;
	private Date currentTime;
	private String IDCard;
	private Integer rId;
	private int eid;
	private String ename;
	private String telephone;
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	private String sex;
	private int deptId;
	private String operator;
	private Integer operatorId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date operatorTime;
	private String address;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private  Date hiredate;

	public Login() {
	}

	public Login(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String IDCard) {
		this.IDCard = IDCard;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Date getOperatorTime() {
		return operatorTime;
	}

	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "Login{" +
				"lid=" + lid +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", status=" + status +
				", currentTime=" + currentTime +
				'}';
	}
}

