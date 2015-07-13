package com.ieeeportal.entity;

import java.io.Serializable;

public class StudentDetailsEntity  implements Serializable
{
	
	private int grpid;
	private String regdate;
	private String tech;
	private int teamsize;
	private String ststatus;
	private String dept;
	private double tfee;
	private double disamt;
	
	private double paidtamt;
	private double unpaidamt;
	private String projname;

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
	private String stdname;
	private String clgname;
	
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
	public String getClgname() {
		return clgname;
	}
	public void setClgname(String clgname) {
		this.clgname = clgname;
	}
	@Override
	public String toString() {
		return "StudentDetailsEntity [grpid=" + grpid + ", regdate=" + regdate
				+ ", tech=" + tech + ", teamsize=" + teamsize + ", ststatus="
				+ ststatus + ", dept=" + dept + ", tfee=" + tfee + ", disamt="
				+ disamt + ", stdname=" + stdname + ", clgname=" + clgname
				+ "]";
	}
	








}
