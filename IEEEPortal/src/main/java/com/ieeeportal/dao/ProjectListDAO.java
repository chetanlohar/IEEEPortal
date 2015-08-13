package com.ieeeportal.dao;

import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.PaperEntity;
import com.ieeeportal.entity.ProjectDetailEntity;
import com.ieeeportal.entity.ProjectRequirementsEntity;

public interface ProjectListDAO {

	
	public ArrayList<ProjectDetailEntity> getSpProjectList(int domid);
	public ArrayList<ProjectDetailEntity> getProjectList(int domid);
	public String addRequirements(ProjectRequirementsEntity projReqEntity);
	public ArrayList<DomainEntity> getProjectDomain();
	public ArrayList<PaperEntity> getPapersName(DomainEntity domainEntity);
	public int getDomainId(DomainEntity domainEntity);
	//public String addRequirements(ProjectRequirementsEntity projReqEntity);
	public boolean assignedProject(ProjectDetailEntity detailEntity); 
	public List<ProjectDetailEntity> getProjectAssigned(ProjectDetailEntity detailEntity);
	public String getFilePath(String fileid);
}
