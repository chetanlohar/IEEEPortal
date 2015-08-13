package com.ieeeportal.service;

import java.util.List;

import com.ieeeportal.entity.CollegeEntity;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;

public interface StudentRegistrationService {

	public List<StudentDetailsEntity> studentList(int enqid);
	public String insertRegistrationRecord(StudentEntity studententity);
	public List<StudentDetailsEntity> registerStudent(CollegeEntity collegeEntity);
	public int getGrpId();
	public List<StudentDetailsEntity> getEmailList(int goupId);
}
