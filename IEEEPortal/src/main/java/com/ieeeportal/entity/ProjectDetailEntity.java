package com.ieeeportal.entity;

import java.io.Serializable;

public class ProjectDetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int prjid;
    private String prjsta;
    private String prjyear;
    private String prjtitle;
    private String prjpath;
    private String prjtype;
    private String prjdom;
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
	
	@Override
	public String toString() {
		return "ProjectDetailEntity [prjid=" + prjid + ", prjsta=" + prjsta
				+ ", prjyear=" + prjyear + ", prjtitle=" + prjtitle
				+ ", prjpath=" + prjpath + ", prjtype=" + prjtype + ", prjdom="
				+ prjdom + "]";
	}
   
}
