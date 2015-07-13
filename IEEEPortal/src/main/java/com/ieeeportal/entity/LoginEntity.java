package com.ieeeportal.entity;

import java.io.Serializable;

public class LoginEntity implements Serializable{

	
	private String LoginEmailId;
	private String LoginPassword;
	private String LoginRole;
	public String getLoginEmailId() {
		return LoginEmailId;
	}
	public void setLoginEmailId(String loginEmailId) {
		LoginEmailId = loginEmailId;
	}
	public String getLoginPassword() {
		return LoginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		LoginPassword = loginPassword;
	}
	public String getLoginRole() {
		return LoginRole;
	}
	public void setLoginRole(String loginRole) {
		LoginRole = loginRole;
	}
	
	
	
	
	public LoginEntity() {
		super();
		}
	
		
	
}
