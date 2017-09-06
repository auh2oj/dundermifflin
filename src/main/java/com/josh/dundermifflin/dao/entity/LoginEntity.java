package com.josh.dundermifflin.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeLogins")
public class LoginEntity {
	private int loginId;
	private String username;
	private String password;
	private String role;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getLoginId() {
		return loginId;
	}
	
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	
	@Column(length=30)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(length=30)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=30)
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginEntity [loginId=" + loginId + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}
	

}
