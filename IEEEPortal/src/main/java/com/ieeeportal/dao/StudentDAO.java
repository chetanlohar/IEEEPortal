package com.ieeeportal.dao;

import java.util.ArrayList;

import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentRegistrationEntity;

public interface StudentDAO {

	public void insertRecord(StudentRegistrationEntity studregent);

	public void updateRecord();

	public void deleteRecord();

	public void selectRecord();
	public ArrayList<StudentDetailsEntity> getAllStudentList();
}
