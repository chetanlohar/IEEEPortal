package com.ieeeportal.service;

import java.util.List;

import com.ieeeportal.entity.EmployeeEntity;

public interface EmployeeRegistrationService {

	public boolean registerEmployee(EmployeeEntity employe);
	public List getEmployeeRecords();
	
}
