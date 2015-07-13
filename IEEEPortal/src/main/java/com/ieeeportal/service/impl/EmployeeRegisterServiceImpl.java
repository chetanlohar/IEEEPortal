package com.ieeeportal.service.impl;

import com.ieeeportal.dao.EmployeeDAO;
import com.ieeeportal.dao.impl.EmployeeDaoImpl;
import com.ieeeportal.entity.EmployeeEntity;
import com.ieeeportal.service.EmployeeRegistrationService;

public class EmployeeRegisterServiceImpl implements EmployeeRegistrationService{
 
	EmployeeDAO employeeDAO;
	public EmployeeRegisterServiceImpl()
	{
		this.employeeDAO = new EmployeeDaoImpl();
	}
	public void registerEmployee(EmployeeEntity employee) {
		employeeDAO.insertEmpRecords(employee);
	}
}
