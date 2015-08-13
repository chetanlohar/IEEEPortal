package com.ieeeportal.service;

import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.PaperEntity;
import com.ieeeportal.entity.ProjectDetailEntity;
import com.ieeeportal.entity.ProjectRequirementsEntity;

public interface ProjectListService
{
	
	public ArrayList<ProjectDetailEntity> getSpProjectList(int domid);
	public ArrayList<ProjectDetailEntity> getProjectList(int domid);
	public String addRequirements(ProjectRequirementsEntity projReqEntity);
	public ArrayList<DomainEntity> getDomainName();
    public int getDomainId(DomainEntity domainEntity);
    public ArrayList<PaperEntity> getPapersName(DomainEntity domainEntity); 
    public boolean assignProject(ProjectDetailEntity detailEntity); 
    public List<ProjectDetailEntity> getProjectAssigned(ProjectDetailEntity detailEntity);
    public String openFile(String fileid);
}
