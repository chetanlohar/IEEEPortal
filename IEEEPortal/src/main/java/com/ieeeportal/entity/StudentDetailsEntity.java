package com.ieeeportal.entity;

import java.io.Serializable;
import java.util.List;

public class StudentDetailsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int grpid;
	private int enqid;
	private int cityid;
	private int clgid;
	private int domainid;
	private int projid;
	private int refid;
	private String enqdate;
	private String regdate;
	private String city;
	private String tech;
	private String domain;
	private int teamsize;
	private String ststatus;
	private String dept;
	private String stdname;
	private String gender;
	private String phoneno;
	private String emailid;
	private String clgname;
	private double paidtamt;
	private double unpaidamt;
	private double tfee;
	private double disamt;
	private String projname;
	private String reference;
	private List<String> studentNameList; 

	public double getPaidtamt() {
		return paidtamt;
	}

	public void setPaidtamt(double paidtamt) {
		this.paidtamt = paidtamt;
	}

	public double getUnpaidamt() {
		return unpaidamt;
	}

	public void setUnpaidamt(double unpaidamt) {
		this.unpaidamt = unpaidamt;
	}

	public String getProjname() {
		return projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public int getGrpid() {
		return grpid;
	}

	public void setGrpid(int grpid) {
		this.grpid = grpid;
	}

	public int getEnqid() {
		return enqid;
	}

	public void setEnqid(int enqid) {
		this.enqid = enqid;
	}
    
	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getEnqdate() {
		return enqdate;
	}

	public void setEnqdate(String enqdate) {
		this.enqdate = enqdate;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getTech() {
		return tech;
	}

	public void setTech(String tech) {
		this.tech = tech;
	}

	public int getTeamsize() {
		return teamsize;
	}

	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}

	public String getStstatus() {
		return ststatus;
	}

	public void setStstatus(String ststatus) {
		this.ststatus = ststatus;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getTfee() {
		return tfee;
	}

	public void setTfee(double tfee) {
		this.tfee = tfee;
	}

	public double getDisamt() {
		return disamt;
	}

	public void setDisamt(double disamt) {
		this.disamt = disamt;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getClgname() {
		return clgname;
	}

	public void setClgname(String clgname) {
		this.clgname = clgname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
    
	public int getClgid() {
		return clgid;
	}

	public void setClgid(int clgid) {
		this.clgid = clgid;
	}

	public int getDomainid() {
		return domainid;
	}

	public void setDomainid(int domainid) {
		this.domainid = domainid;
	}

	public int getProjid() {
		return projid;
	}

	public void setProjid(int projid) {
		this.projid = projid;
	}

	public int getRefid() {
		return refid;
	}

	public void setRefid(int refid) {
		this.refid = refid;
	}

	/**
	 * @return the studentNameList
	 */
	public List<String> getStudentNameList() {
		return studentNameList;
	}

	/**
	 * @param studentNameList the studentNameList to set
	 */
	public void setStudentNameList(List<String> studentNameList) {
		this.studentNameList = studentNameList;
	}

	@Override
	public String toString() {
		return "StudentDetailsEntity [grpid=" + grpid + ", regdate=" + regdate
				+ ", tech=" + tech + ", teamsize=" + teamsize + ", city="
				+ city + ",ststatus=" + ststatus + ", domain=" + domain
				+ ", dept=" + dept + ", tfee=" + tfee + ", disamt=" + disamt
				+ ", stdname=" + stdname + ",gender=" + gender + ",phoneno="
				+ phoneno + ",emailid=" + emailid + ", clgname=" + clgname
				+ ",reference=" + reference + "]";
	}

}
