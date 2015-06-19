package com.ieeeportal.dao;

import com.ieeeportal.entity.StudentRegistrationEntity;

public interface StudentDAO {

	public void insertRecord(StudentRegistrationEntity studregent);

	public void updateRecord();

	public void deleteRecord();

	public void selectRecord();

}
