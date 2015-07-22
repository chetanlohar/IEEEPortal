package com.ieeeportal.dao;

import java.util.List;

import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;

public interface StudentRegistrationDAO {
	public List<StudentDetailsEntity> studenttoregList(int enqid);
	public String insertStudentRegistrationRecord(StudentEntity studententity);
	public int selectGrpId();
}
