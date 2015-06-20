package com.ieeeportal.service.impl;

import com.ieeeportal.dao.EmployeeRegistrationDAO;
import com.ieeeportal.dao.impl.EmployeeRegDaoImpl;
import com.ieeeportal.entity.EmployeeRegistrationEntity;
import com.ieeeportal.service.EmployeeRegistrationService;

public class EmployeeRegisterServiceImpl implements EmployeeRegistrationService{
 
	EmployeeRegistrationDAO employeeRegistrationDAO=new EmployeeRegDaoImpl();
	
	public void registerEmployee(EmployeeRegistrationEntity employee) {
		
		employeeRegistrationDAO.insertEmpRegRecords(employee);
		
	}

	

	
}
