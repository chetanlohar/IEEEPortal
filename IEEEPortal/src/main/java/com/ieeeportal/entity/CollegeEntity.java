package com.ieeeportal.entity;

import java.io.Serializable;

public class CollegeEntity implements Serializable{

	
	private int collegeId;
	private String collegeName;
	
	public int getCollegeId() {
		return collegeId;
	}
	
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	
	
}
