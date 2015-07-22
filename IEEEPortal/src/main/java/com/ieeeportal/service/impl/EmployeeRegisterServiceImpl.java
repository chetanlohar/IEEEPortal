package com.ieeeportal.service.impl;

import java.util.List;

import com.ieeeportal.dao.EmployeeDAO;
import com.ieeeportal.dao.impl.EmployeeDaoImpl;
import com.ieeeportal.entity.EmployeeEntity;
import com.ieeeportal.service.EmployeeRegistrationService;

public class EmployeeRegisterServiceImpl implements EmployeeRegistrationService{
 
	EmployeeDAO employeeDAO;
	List<EmployeeEntity> emplist;
	public EmployeeRegisterServiceImpl()
	{
		this.employeeDAO = new EmployeeDaoImpl();
	}
	public boolean registerEmployee(EmployeeEntity employee) {
		return employeeDAO.insertEmpRecords(employee);
	}
	@Override
	public List getEmployeeRecords() {
		emplist=employeeDAO.getEmployeeRecords();
		return emplist;
	}
}
