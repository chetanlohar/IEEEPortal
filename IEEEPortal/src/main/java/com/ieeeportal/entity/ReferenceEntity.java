package com.ieeeportal.entity;

import java.io.Serializable;

public class ReferenceEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4120194537767452832L;
	private int referenceId;
	private String referenceName;
	
	
	public int getReferenceId() {
		return referenceId;
	}
	
	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}
	
	public String getReferenceName() {
		return referenceName;
	}
	
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	
	
	
	
}
