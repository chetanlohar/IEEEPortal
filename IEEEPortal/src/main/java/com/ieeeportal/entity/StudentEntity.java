package com.ieeeportal.entity;

import java.io.Serializable;
import java.util.List;



public class StudentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int enquiryId;
	private String enquiryDate;
	private String regDate;
	private int StudentCityId;
	private int StudentCollegeId;
	private String StudentDepartment;
	private String StudentTechnology;
	private int StudentDomainId;
	private int StudentTeamsize;
	private int StudentReferenceId;
	private String projecttitle;
	private double totalfee;
	private double discount;
	private List<String>  StudentNameList;
	private List<String> StudentContactList;
	private List<String> StudentEmailList;
	private List<String> StudentGenderList;
	private List<String> StudentpaperList;
    
	
	public StudentEntity() {
	
	}

	public StudentEntity(int enquiryId, String enquiryDate, String regDate,int studentCityId,
			int studentCollegeId, String studentDepartment,
			String studentTechnology, int studentDomainId, int studentTeamsize,
			int studentReferenceId, String projtitle, double totfee, double disamt,
			List<String> studentNameList,
			List<String> studentContactList, List<String> studentEmailList,
			List<String> studentGenderList) {
		super();
		this.enquiryId = enquiryId;
		this.enquiryDate = enquiryDate;
		this.regDate = regDate;
		StudentCityId = studentCityId;
		StudentCollegeId = studentCollegeId;
		StudentDepartment = studentDepartment;
		StudentTechnology = studentTechnology;
		StudentDomainId = studentDomainId;
		StudentTeamsize = studentTeamsize;
		StudentReferenceId = studentReferenceId;
		projecttitle = projtitle;
		totalfee = totfee;
		discount = disamt;
		StudentNameList = studentNameList;
		StudentContactList = studentContactList;
		StudentEmailList = studentEmailList;
		StudentGenderList = studentGenderList;
	}
    
	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(String enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getStudentCityId() {
		return StudentCityId;
	}

	public void setStudentCityId(int studentCityId) {
		StudentCityId = studentCityId;
	}

	public int getStudentCollegeId() {
		return StudentCollegeId;
	}

	public void setStudentCollegeId(int studentCollegeId) {
		StudentCollegeId = studentCollegeId;
	}

	public String getStudentDepartment() {
		return StudentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		StudentDepartment = studentDepartment;
	}

	public String getStudentTechnology() {
		return StudentTechnology;
	}

	public void setStudentTechnology(String studentTechnology) {
		StudentTechnology = studentTechnology;
	}

	public int getStudentDomainId() {
		return StudentDomainId;
	}

	public void setStudentDomainId(int studentDomainId) {
		StudentDomainId = studentDomainId;
	}

	public int getStudentTeamsize() {
		return StudentTeamsize;
	}

	public void setStudentTeamsize(int studentTeamsize) {
		StudentTeamsize = studentTeamsize;
	}

	public int getStudentReferenceId() {
		return StudentReferenceId;
	}

	public void setStudentReferenceId(int studentReferenceId) {
		StudentReferenceId = studentReferenceId;
	}
    
	public String getProjecttitle() {
		return projecttitle;
	}

	public void setProjecttitle(String projecttitle) {
		this.projecttitle = projecttitle;
	}

	public double getTotalfee() {
		return totalfee;
	}

	public void setTotalfee(double totalfee) {
		this.totalfee = totalfee;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public List<String> getStudentNameList() {
		return StudentNameList;
	}

	public void setStudentNameList(List<String> studentNameList) {
		StudentNameList = studentNameList;
	}

	public List<String> getStudentContactList() {
		return StudentContactList;
	}

	public void setStudentContactList(List<String> studentContactList) {
		StudentContactList = studentContactList;
	}

	public List<String> getStudentEmailList() {
		return StudentEmailList;
	}

	public void setStudentEmailList(List<String> studentEmailList) {
		StudentEmailList = studentEmailList;
	}

	public List<String> getStudentGenderList() {
		return StudentGenderList;
	}

	public void setStudentGenderList(List<String> studentGenderList) {
		StudentGenderList = studentGenderList;
	}

	/**
	 * @return the studentpaperList
	 */
	public List<String> getStudentpaperList() {
		return StudentpaperList;
	}

	/**
	 * @param studentpaperList the studentpaperList to set
	 */
	public void setStudentpaperList(List<String> studentpaperList) {
		StudentpaperList = studentpaperList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
