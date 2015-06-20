package com.ieeeportal.entity;

import java.io.Serializable;

public class StudentRegistrationEntity implements Serializable{

	private static final long serialVersionUID = 1L;
    private int grpid;
    private String regdate;
    private String tech;
    private int teamsz;
    private String dept;
    private String studstat;
    private double totfee;
    private double discount;
    
    public StudentRegistrationEntity(){
    }

	public int getGrpid() {
		return grpid;
	}

	public void setGrpid(int grpid) {
		this.grpid = grpid;
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

	public int getTeamsz() {
		return teamsz;
	}

	public void setTeamsz(int teamsz) {
		this.teamsz = teamsz;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStudstat() {
		return studstat;
	}

	public void setStudstat(String studstat) {
		this.studstat = studstat;
	}

	public double getTotfee() {
		return totfee;
	}

	public void setTotfee(double totfee) {
		this.totfee = totfee;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
 
}
