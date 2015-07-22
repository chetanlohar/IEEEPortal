package com.ieeeportal.service.impl;

import java.util.List;

import com.ieeeportal.dao.StudentRegistrationDAO;
import com.ieeeportal.dao.impl.StudentRegistrationDAOImpl;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;
import com.ieeeportal.service.StudentRegistrationService;

public class StudentRegistrationServiceImpl implements StudentRegistrationService{

	StudentRegistrationDAO srDAO = null;
	public StudentRegistrationServiceImpl() {
		srDAO = new StudentRegistrationDAOImpl();
	}
	@Override
	public List<StudentDetailsEntity> studentList(int enqid) {
		
		return srDAO.studenttoregList(enqid);
	}
	@Override
	public String insertRegistrationRecord(StudentEntity studententity) {
		
		return srDAO.insertStudentRegistrationRecord(studententity);
	}
	
	@Override
	public int getGrpId() {
		
		return srDAO.selectGrpId();
	}
	

}
