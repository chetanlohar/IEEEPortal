package com.ieeeportal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ieeeportal.entity.EmployeeRegistrationEntity;
import com.ieeeportal.service.impl.EmployeeRegisterServiceImpl;

/**
 * Servlet implementation class EmployeeRegistrationController
 */
@WebServlet("/EmployeeRegistrationController")
public class EmployeeRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	 
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* int empID=();*/
		 String name=request.getParameter("empName");
		 String emailID=request.getParameter("empEmailID");
		 String password=request.getParameter("empPassword");
		 String designation=request.getParameter("empDesignation");
		 String contactNo=request.getParameter("empContactNo");;
		 String gender=request.getParameter("empGender");
		 String dateOfJoinning=request.getParameter("empDOJ");  
		 String street=request.getParameter("empStreet");
		 String city=request.getParameter("empCity");
		 
        //calling Registration Service method of EmployeeRegistrationService
		 
		EmployeeRegistrationEntity employee=new EmployeeRegistrationEntity();
		employee.setEmpID(Integer.parseInt(request.getParameter("empID")));
		employee.setEmpEmailID(emailID);
		employee.setEmpName(name);
		employee.setEmpPassword(password);
		employee.setEmpdesignation(designation);
		employee.setEmpContactNo(contactNo);
		employee.setEmpDateOfJoinning(dateOfJoinning);
		employee.setEmpStreet(street);
		employee.setEmpCity(city);
		try{
			System.out.println("Emp Name"+employee.getEmpName());
			EmployeeRegisterServiceImpl emImpl=new EmployeeRegisterServiceImpl();
			emImpl.registerEmployee(employee);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
