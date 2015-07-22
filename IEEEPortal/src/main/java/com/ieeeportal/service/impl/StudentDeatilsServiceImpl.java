package com.ieeeportal.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.dao.StudentDAO;
import com.ieeeportal.dao.impl.StudentDAOImpl;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.service.StudentDetailsService;
import com.ieeeportal.util.StudentOperation;

public class StudentDeatilsServiceImpl implements StudentDetailsService
{
	StudentDAO  studentDAO=new StudentDAOImpl();
List<StudentDetailsEntity> studentDetailsEntities=new ArrayList<StudentDetailsEntity>();
StudentDetailsEntity detailsEntity=new StudentDetailsEntity();
StudentOperation studentOperation=new StudentOperation();
	public List<StudentDetailsEntity> getallStudent() 
	{
		// TODO Auto-generated method stub
		studentDetailsEntities=studentDAO.getAllStudentList();
		
		return studentDetailsEntities;
	}

	public List<StudentDetailsEntity> getStudent(String name)
	{
		// TODO Auto-generated method stub
		studentDetailsEntities=studentOperation.getSpStudent(name);
		
		return studentDetailsEntities;
	}

}
