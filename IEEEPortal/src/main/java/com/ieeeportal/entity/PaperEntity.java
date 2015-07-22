package com.ieeeportal.entity;

import java.io.Serializable;

public class PaperEntity implements Serializable{

	private int paperiD;
	private String papertitle;
	private int projectid;
	private int groupid;
	/**
	 * @return the paperiD
	 */
	public int getPaperiD() {
		return paperiD;
	}
	/**
	 * @param paperiD the paperiD to set
	 */
	public void setPaperiD(int paperiD) {
		this.paperiD = paperiD;
	}
	/**
	 * @return the papertitle
	 */
	public String getPapertitle() {
		return papertitle;
	}
	/**
	 * @param papertitle the papertitle to set
	 */
	public void setPapertitle(String papertitle) {
		this.papertitle = papertitle;
	}
	/**
	 * @return the projectid
	 */
	public int getProjectid() {
		return projectid;
	}
	/**
	 * @param projectid the projectid to set
	 */
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	/**
	 * @return the groupid
	 */
	public int getGroupid() {
		return groupid;
	}
	/**
	 * @param groupid the groupid to set
	 */
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
	}
