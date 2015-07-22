package com.ieeeportal.service;

import java.util.List;

import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;

public interface StudentRegistrationService {

	public List<StudentDetailsEntity> studentList(int enqid);
	public String insertRegistrationRecord(StudentEntity studententity);
	public int getGrpId();
}
