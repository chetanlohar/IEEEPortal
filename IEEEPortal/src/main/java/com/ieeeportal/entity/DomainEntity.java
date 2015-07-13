package com.ieeeportal.entity;

import java.io.Serializable;

public class DomainEntity implements Serializable{

	
	private int domainId;
	private String domainName;
	
	public int getDomainId() {
		return domainId;
	}
	
	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}
	
	public String getDomainName() {
		return domainName;
	}
	
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	
	
}
