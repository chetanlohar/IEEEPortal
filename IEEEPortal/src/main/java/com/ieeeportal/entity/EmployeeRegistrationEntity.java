package com.ieeeportal.entity;

import java.io.Serializable;

public class EmployeeRegistrationEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int empID;
	private String empName;
	private String empEmailID;
	private String empPassword;
	private String empdesignation;
	private String empContactNo;
	private String empGender;
	private String empDateOfJoinning;  
	private String empStreet;
	private String empCity;
	
	public EmployeeRegistrationEntity() {
		// TODO Auto-generated constructor stub
	}
	public EmployeeRegistrationEntity(int empID, String empName,
			String empEmailID, String empPassword, String empdesignation,
			String empContactNo, String empGender, String empDateOfJoinning,
			String empStreet, String empCity) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empEmailID = empEmailID;
		this.empPassword = empPassword;
		this.empdesignation = empdesignation;
		this.empContactNo = empContactNo;
		this.empGender = empGender;
		this.empDateOfJoinning = empDateOfJoinning;
		this.empStreet = empStreet;
		this.empCity = empCity;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmailID() {
		return empEmailID;
	}
	public void setEmpEmailID(String empEmailID) {
		this.empEmailID = empEmailID;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpdesignation() {
		return empdesignation;
	}
	public void setEmpdesignation(String empdesignation) {
		this.empdesignation = empdesignation;
	}
	public String getEmpContactNo() {
		return empContactNo;
	}
	public void setEmpContactNo(String empContactNo) {
		this.empContactNo = empContactNo;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpDateOfJoinning() {
		return empDateOfJoinning;
	}
	public void setEmpDateOfJoinning(String empDateOfJoinning) {
		this.empDateOfJoinning = empDateOfJoinning;
	}
	public String getEmpStreet() {
		return empStreet;
	}
	public void setEmpStreet(String empStreet) {
		this.empStreet = empStreet;
	}
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
