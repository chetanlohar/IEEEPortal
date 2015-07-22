package com.ieeeportal.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProjectDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int prjid;
    private String prjsta;
    private String prjyear;
    private String prjtitle;
    private String prjpath;
    private String prjtype;
    private String prjdom;
    private int empId;
    private int domainId;
    private String empName;
    
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	private Timestamp dateOfAssign;

    public int getDomainId() {
		return domainId;
	}
	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}
	public int getPrjid() {
		return prjid;
	}
	public void setPrjid(int prjid) {
		this.prjid = prjid;
	}
	public String getPrjsta() {
		return prjsta;
	}
	public void setPrjsta(String prjsta) {
		this.prjsta = prjsta;
	}
	public String getPrjyear() {
		return prjyear;
	}
	public void setPrjyear(String prjyear) {
		this.prjyear = prjyear;
	}
	public String getPrjtitle() {
		return prjtitle;
	}
	public void setPrjtitle(String prjtitle) {
		this.prjtitle = prjtitle;
	}
	public String getPrjpath() {
		return prjpath;
	}
	public void setPrjpath(String prjpath) {
		this.prjpath = prjpath;
	}
	public String getPrjtype() {
		return prjtype;
	}
	public void setPrjtype(String prjtype) {
		this.prjtype = prjtype;
	}
	public String getPrjdom() {
		return prjdom;
	}
	public void setPrjdom(String prjdom) {
		this.prjdom = prjdom;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	/**
	 * @return the dateOfAssign
	 */
	public Timestamp getDateOfAssign() {
		return dateOfAssign;
	}
	/**
	 * @param dateOfAssign the dateOfAssign to set
	 */
	public void setDateOfAssign(Timestamp dateOfAssign) {
		this.dateOfAssign = dateOfAssign;
	}
	@Override
	public String toString() {
		return "ProjectDetailEntity [prjid=" + prjid + ", prjsta=" + prjsta
				+ ", prjyear=" + prjyear + ", prjtitle=" + prjtitle
				+ ", prjpath=" + prjpath + ", prjtype=" + prjtype + ", prjdom="
				+ prjdom + "]";
	}
   
}
