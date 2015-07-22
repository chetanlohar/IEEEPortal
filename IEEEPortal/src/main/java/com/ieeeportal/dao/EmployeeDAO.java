package com.ieeeportal.dao;

import java.util.List;

import com.ieeeportal.entity.EmployeeEntity;

public interface EmployeeDAO {

	//This Method For Employee Registration(INPUT=Employee Object) and Output void
	
	public boolean insertEmpRecords(EmployeeEntity employee);
	public List readEmpRecords(EmployeeEntity employee);
	public List<EmployeeEntity> getEmployeeRecords();//retrive all employee Personal Records
}
