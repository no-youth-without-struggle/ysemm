package com.aaa.ysemm.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ProjectName: ysemm
 * @Package: com.aaa.ysemm.customer.entity
 * @Author: ${白帅}
 * @Description: ${description}
 * @Date: 2019/7/28 17:25
 * @Version: 1.0
 */
/*@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString*/
public class UserLogin {
    private Integer uid;
    private String username;
    private String telephone;
    private String password;
    private  String passwordSalt;
    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date time;
    private String payPassword;
    private String phonecode;
    public UserLogin(Integer uid, String username, String telephone, String password, String passwordSalt, Integer status, Date time, String payPassword, String phonecode) {
        this.uid = uid;
        this.username = username;
        this.telephone = telephone;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.status = status;
        this.time = time;
        this.payPassword = payPassword;
        this.phonecode = phonecode;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }
}
