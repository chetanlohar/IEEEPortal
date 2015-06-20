package com.ieeeportal.entity;

import java.io.Serializable;
import java.util.List;



public class StudentEnquiryEntity implements Serializable {

	private String enquiryDate;
	private String StudentCity;
	private String StudentCollege;
	private String StudentDepartment;
	private String StudentTechnology;
	private String StudentDomain;
	private int StudentTeamsize;
	private List  StudentNameList;
	private List StudentContactList;
	private List StudentEmailList;
	

	public StudentEnquiryEntity() {
	
	}


	/**
	 * @param enquiryDate
	 * @param studentCity
	 * @param studentCollege
	 * @param studentDepartment
	 * @param studentTechnology
	 * @param studentDomain
	 * @param studentTeamsize
	 * @param studentNameList
	 * @param studentContactList
	 * @param studentEmailList
	 */
	public StudentEnquiryEntity(String enquiryDate, String studentCity,
			String studentCollege, String studentDepartment,
			String studentTechnology, String studentDomain,
			int studentTeamsize, List studentNameList, List studentContactList,
			List studentEmailList) {
		super();
		this.enquiryDate = enquiryDate;
		StudentCity = studentCity;
		StudentCollege = studentCollege;
		StudentDepartment = studentDepartment;
		StudentTechnology = studentTechnology;
		StudentDomain = studentDomain;
		StudentTeamsize = studentTeamsize;
		StudentNameList = studentNameList;
		StudentContactList = studentContactList;
		StudentEmailList = studentEmailList;
	}


	/**
	 * @return the enquiryDate
	 */
	public String getEnquiryDate() {
		return enquiryDate;
	}

	/**
	 * @param enquiryDate the enquiryDate to set
	 */
	public void setEnquiryDate(String enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	/**
	 * @return the studentCity
	 */
	public String getStudentCity() {
		return StudentCity;
	}

	/**
	 * @param studentCity the studentCity to set
	 */
	public void setStudentCity(String studentCity) {
		StudentCity = studentCity;
	}

	/**
	 * @return the studentCollege
	 */
	public String getStudentCollege() {
		return StudentCollege;
	}

	/**
	 * @param studentCollege the studentCollege to set
	 */
	public void setStudentCollege(String studentCollege) {
		StudentCollege = studentCollege;
	}

	/**
	 * @return the studentDepartment
	 */
	public String getStudentDepartment() {
		return StudentDepartment;
	}

	/**
	 * @param studentDepartment the studentDepartment to set
	 */
	public void setStudentDepartment(String studentDepartment) {
		StudentDepartment = studentDepartment;
	}

	/**
	 * @return the studentTechnology
	 */
	public String getStudentTechnology() {
		return StudentTechnology;
	}

	/**
	 * @param studentTechnology the studentTechnology to set
	 */
	public void setStudentTechnology(String studentTechnology) {
		StudentTechnology = studentTechnology;
	}

	/**
	 * @return the studentTeamsize
	 */
	public int getStudentTeamsize() {
		return StudentTeamsize;
	}

	/**
	 * @param studentTeamsize the studentTeamsize to set
	 */
	public void setStudentTeamsize(int studentTeamsize) {
		StudentTeamsize = studentTeamsize;
	}

	/**
	 * @return the studentNameList
	 */
	public List getStudentNameList() {
		return StudentNameList;
	}

	/**
	 * @param studentNameList the studentNameList to set
	 */
	public void setStudentNameList(List studentNameList) {
		StudentNameList = studentNameList;
	}

	/**
	 * @return the studentContactList
	 */
	public List getStudentContactList() {
		return StudentContactList;
	}

	/**
	 * @param studentContactList the studentContactList to set
	 */
	public void setStudentContactList(List studentContactList) {
		StudentContactList = studentContactList;
	}

	/**
	 * @return the studentEmailList
	 */
	public List getStudentEmailList() {
		return StudentEmailList;
	}

	/**
	 * @param studentEmailList the studentEmailList to set
	 */
	public void setStudentEmailList(List studentEmailList) {
		StudentEmailList = studentEmailList;
	}

	/**
	 * @return the studentDomain
	 */
	public String getStudentDomain() {
		return StudentDomain;
	}

	/**
	 * @param studentDomain the studentDomain to set
	 */
	public void setStudentDomain(String studentDomain) {
		StudentDomain = studentDomain;
	}
	
	
	
	
	
}
