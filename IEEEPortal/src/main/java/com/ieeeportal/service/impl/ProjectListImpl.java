package com.ieeeportal.service.impl;

import java.util.ArrayList;

import com.ieeeportal.dao.ProjectListDAO;
import com.ieeeportal.dao.impl.ProjectListDAOImpl;
import com.ieeeportal.entity.ProjectDetailEntity;
import com.ieeeportal.service.ProjectListService;

public class ProjectListImpl implements ProjectListService {

	ProjectListDAO projectListDAO=new ProjectListDAOImpl();
	ArrayList<ProjectDetailEntity> pjlist=new ArrayList<ProjectDetailEntity>();
	public ArrayList<ProjectDetailEntity> getProjectList()
	{
		// TODO Auto-generated method stub
		pjlist=projectListDAO.getProjectList();
		return pjlist;
	}

}
