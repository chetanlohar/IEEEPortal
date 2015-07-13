package com.ieeeportal.entity;

import java.io.Serializable;
import java.util.List;



public class StudentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String enquiryDate;
	private int StudentCityId;
	private int StudentCollegeId;
	private String StudentDepartment;
	private String StudentTechnology;
	private int StudentDomainId;
	private int StudentTeamsize;
	private int StudentReferenceId;
	private List<String>  StudentNameList;
	private List<String> StudentContactList;
	private List<String> StudentEmailList;
	private List<String> StudentGenderList;
	
	public StudentEntity() {
	
	}

	public StudentEntity(String enquiryDate, int studentCityId,
			int studentCollegeId, String studentDepartment,
			String studentTechnology, int studentDomainId, int studentTeamsize,
			int studentReferenceId, List<String> studentNameList,
			List<String> studentContactList, List<String> studentEmailList,
			List<String> studentGenderList) {
		super();
		this.enquiryDate = enquiryDate;
		StudentCityId = studentCityId;
		StudentCollegeId = studentCollegeId;
		StudentDepartment = studentDepartment;
		StudentTechnology = studentTechnology;
		StudentDomainId = studentDomainId;
		StudentTeamsize = studentTeamsize;
		StudentReferenceId = studentReferenceId;
		StudentNameList = studentNameList;
		StudentContactList = studentContactList;
		StudentEmailList = studentEmailList;
		StudentGenderList = studentGenderList;
	}

	public String getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(String enquiryDate) {
		this.enquiryDate = enquiryDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
	
	
	
	
	
}
