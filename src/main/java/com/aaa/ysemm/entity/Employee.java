package com.aaa.ysemm.entity;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * table name:  employee
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */
public class Employee {
	private String IDCard;
	private Integer rId;
	private int eid;
	private int lid;
	private String ename;
	private String telephone;
	private String email;
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	private String sex;
	private int deptId;
	private int status;
	private String operator;
	private Integer operatorId;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date operatorTime;
	private String password;
	private String address;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private  Date hiredate;

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee{" +
				"IDCard='" + IDCard + '\'' +
				", rId=" + rId +
				", eid=" + eid +
				", lid=" + lid +
				", ename='" + ename + '\'' +
				", telephone='" + telephone + '\'' +
				", email='" + email + '\'' +
				", birthday=" + birthday +
				", sex='" + sex + '\'' +
				", deptId=" + deptId +
				", status=" + status +
				", operator='" + operator + '\'' +
				", operatorId=" + operatorId +
				", operatorTime=" + operatorTime +
				", password='" + password + '\'' +
				", address='" + address + '\'' +
				", hiredate=" + hiredate +
				'}';
	}

	public Employee(String IDCard, Integer rId, int eid, int lid, String ename, String telephone, String email, Date birthday, String sex, int deptId, int status, String operator, Integer operatorId, Date operatorTime, String password, String address, Date hiredate) {
		this.IDCard = IDCard;
		this.rId = rId;
		this.eid = eid;
		this.lid = lid;
		this.ename = ename;
		this.telephone = telephone;
		this.email = email;
		this.birthday = birthday;
		this.sex = sex;
		this.deptId = deptId;
		this.status = status;
		this.operator = operator;
		this.operatorId = operatorId;
		this.operatorTime = operatorTime;
		this.password = password;
		this.address = address;
		this.hiredate = hiredate;
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

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
}

