package com.aaa.ysemm.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * table name:  login
 * author name: Mr Chen
 * create time: 2019-07-31 20:08:49
 */ 
@Component
public class Login {
	private int lid;
	private String email;
	private String password;
	private int status;
	private Date currentTime;

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

