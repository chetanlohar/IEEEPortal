package com.ieeeportal.entity;

public class ProjectRequirementsEntity {
	
	
	private int groupId;
	private String requirements;
	private String dateOfRequirements;
	
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
		
	
	public String getDateOfRequirements() {
		return dateOfRequirements;
	}
	public void setDateOfRequirements(String dateOfRequirements) {
		this.dateOfRequirements = dateOfRequirements;
	}
	public ProjectRequirementsEntity() {
		super();
		this.groupId = groupId;
		this.requirements = requirements;
		this.dateOfRequirements = dateOfRequirements;
	}
	
	
}
