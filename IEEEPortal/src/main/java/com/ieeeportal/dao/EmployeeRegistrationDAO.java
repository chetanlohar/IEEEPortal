package com.ieeeportal.dao;

import com.ieeeportal.entity.EmployeeRegistrationEntity;

public interface EmployeeRegistrationDAO {

	//This Method For Employee Registration(INPUT=Employee Object) and Output void
	
	public void insertEmpRegRecords(EmployeeRegistrationEntity employee);
	
}
