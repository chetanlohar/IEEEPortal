package com.ieeeportal.entity;

import java.io.Serializable;

public class EmployeeEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int empID;
	private String empName;
	private String empEmailID;
	private String empPassword;
	private String empdesignation;
	private String empContactNo;
	private String empGender;
	private String empDateOfJoinning;  
	private String empAddress;
	private String empRole;  
	private String reportingManager;
	
	
	public EmployeeEntity() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param empID
	 * @param empName
	 * @param empEmailID
	 * @param empPassword
	 * @param empdesignation
	 * @param empContactNo
	 * @param empGender
	 * @param empDateOfJoinning
	 * @param empAddress
	 * @param empRole
	 * @param reportingManager
	 */
	public EmployeeEntity(int empID, String empName, String empEmailID,
			String empPassword, String empdesignation, String empContactNo,
			String empGender, String empDateOfJoinning, String empAddress,
			String empRole, String reportingManager) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empEmailID = empEmailID;
		this.empPassword = empPassword;
		this.empdesignation = empdesignation;
		this.empContactNo = empContactNo;
		this.empGender = empGender;
		this.empDateOfJoinning = empDateOfJoinning;
		this.empAddress = empAddress;
		this.empRole = empRole;
		this.reportingManager = reportingManager;
	}


	/**
	 * @return the empID
	 */
	public int getEmpID() {
		return empID;
	}


	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}


	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}


	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	/**
	 * @return the empEmailID
	 */
	public String getEmpEmailID() {
		return empEmailID;
	}


	/**
	 * @param empEmailID the empEmailID to set
	 */
	public void setEmpEmailID(String empEmailID) {
		this.empEmailID = empEmailID;
	}


	/**
	 * @return the empPassword
	 */
	public String getEmpPassword() {
		return empPassword;
	}


	/**
	 * @param empPassword the empPassword to set
	 */
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}


	/**
	 * @return the empdesignation
	 */
	public String getEmpdesignation() {
		return empdesignation;
	}


	/**
	 * @param empdesignation the empdesignation to set
	 */
	public void setEmpdesignation(String empdesignation) {
		this.empdesignation = empdesignation;
	}


	/**
	 * @return the empContactNo
	 */
	public String getEmpContactNo() {
		return empContactNo;
	}


	/**
	 * @param empContactNo the empContactNo to set
	 */
	public void setEmpContactNo(String empContactNo) {
		this.empContactNo = empContactNo;
	}


	/**
	 * @return the empGender
	 */
	public String getEmpGender() {
		return empGender;
	}


	/**
	 * @param empGender the empGender to set
	 */
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}


	/**
	 * @return the empDateOfJoinning
	 */
	public String getEmpDateOfJoinning() {
		return empDateOfJoinning;
	}


	/**
	 * @param empDateOfJoinning the empDateOfJoinning to set
	 */
	public void setEmpDateOfJoinning(String empDateOfJoinning) {
		this.empDateOfJoinning = empDateOfJoinning;
	}


	/**
	 * @return the empAddress
	 */
	public String getEmpAddress() {
		return empAddress;
	}


	/**
	 * @param empAddress the empAddress to set
	 */
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}


	/**
	 * @return the empRole
	 */
	public String getEmpRole() {
		return empRole;
	}


	/**
	 * @param empRole the empRole to set
	 */
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}


	/**
	 * @return the reportingManager
	 */
	public String getReportingManager() {
		return reportingManager;
	}


	/**
	 * @param reportingManager the reportingManager to set
	 */
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}