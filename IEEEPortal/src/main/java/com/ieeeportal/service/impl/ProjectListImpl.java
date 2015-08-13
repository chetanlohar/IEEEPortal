package com.ieeeportal.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.dao.ProjectListDAO;
import com.ieeeportal.dao.impl.ProjectListDAOImpl;
import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.PaperEntity;
import com.ieeeportal.entity.ProjectDetailEntity;
import com.ieeeportal.entity.ProjectRequirementsEntity;
import com.ieeeportal.service.ProjectListService;

public class ProjectListImpl implements ProjectListService {

	ProjectListDAO projectListDAO = new ProjectListDAOImpl();
	ArrayList<ProjectDetailEntity> pjlist = new ArrayList<ProjectDetailEntity>();
	ArrayList<PaperEntity> paperList = null;
	ArrayList<DomainEntity> domainList = null;
	List<ProjectDetailEntity> assignedProject;
	boolean flag;
	int domainId;

	public ProjectListImpl() {
		this.domainList = new ArrayList<DomainEntity>();
		this.pjlist = new ArrayList<ProjectDetailEntity>();
		this.projectListDAO = new ProjectListDAOImpl();
		this.paperList = new ArrayList<PaperEntity>();
		this.domainId = 0;
		this.assignedProject = null;
		this.flag = false;
	}

	public ArrayList<ProjectDetailEntity> getProjectList(int domid) {
		pjlist = projectListDAO.getProjectList(domid);
		return pjlist;
	}

	@Override
	public String addRequirements(ProjectRequirementsEntity projReqEntity) {

		String result = projectListDAO.addRequirements(projReqEntity);

		return result;
	}

	@Override
	public ArrayList<DomainEntity> getDomainName() {

		domainList = projectListDAO.getProjectDomain();
		return domainList;
	}

	@Override
	public ArrayList<PaperEntity> getPapersName(DomainEntity domainEntity) {

		paperList = projectListDAO.getPapersName(domainEntity);
		return paperList;
	}

	@Override
	public int getDomainId(DomainEntity domainEntity) {
		domainId = projectListDAO.getDomainId(domainEntity);
		return domainId;
	}

	@Override
	public boolean assignProject(ProjectDetailEntity detailEntity) {
		flag = projectListDAO.assignedProject(detailEntity);
		return flag;
	}

	@Override
	public List<ProjectDetailEntity> getProjectAssigned(
			ProjectDetailEntity detailEntity) {
		assignedProject = projectListDAO.getProjectAssigned(detailEntity);
		return assignedProject;
	}

	@Override
	public ArrayList<ProjectDetailEntity> getSpProjectList(int domid) {
		
		return projectListDAO.getSpProjectList(domid);
	}

	@Override
	public String openFile(String fileid) {
		
		return projectListDAO.getFilePath(fileid);
	}

}
