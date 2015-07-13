package com.ieeeportal.dao;

import java.util.List;

import com.ieeeportal.entity.EmployeeEntity;

public interface EmployeeDAO {

	//This Method For Employee Registration(INPUT=Employee Object) and Output void
	
	public void insertEmpRecords(EmployeeEntity employee);
	public List readEmpRecords(EmployeeEntity employee);
}
