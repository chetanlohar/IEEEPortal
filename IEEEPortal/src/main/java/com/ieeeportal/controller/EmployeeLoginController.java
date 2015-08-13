package com.ieeeportal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.ieeeportal.entity.EmployeeEntity;
import com.ieeeportal.entity.LoginEntity;
import com.ieeeportal.service.EmployeeRegistrationService;
import com.ieeeportal.service.LoginService;
import com.ieeeportal.service.impl.EmployeeRegisterServiceImpl;
import com.ieeeportal.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class EmployeeLoginController
 */
public class EmployeeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final String ADMINLOGINSUCCESS = "/WEB-INF/jsp/admin/adminhome.jsp";
    private static final String EMPLOYEELOGINSUCCESS="/EmployeeHomePage";
    private static final String LOGINFAILURE = "login";
    private static final String ERROR = "error";
    EmployeeRegistrationService employeeService;
    String username;
    List<EmployeeEntity> employeeRecords;
    HttpSession session;
    public EmployeeLoginController() {
        super();
        this.employeeService=new EmployeeRegisterServiceImpl();
        this.employeeRecords=null; 
        this.username=null;
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
		try{
			ServletContext context = request.getServletContext();
			session = request.getSession();
			String adminun=context.getInitParameter("adminusername");
			String adminpw=context.getInitParameter("adminpassword");
			String userrole = request.getParameter("r1");
			
			
			String formun = request.getParameter("loginuser");
			String formpw = request.getParameter("loginpass");
			
			LoginEntity loginEntity = new LoginEntity();
			
			loginEntity.setLoginEmailId(formun);
			loginEntity.setLoginPassword(formpw);
			loginEntity.setLoginRole(userrole);

			LoginService loginservice = new LoginServiceImpl();
			
			String result = loginservice.LoginCheck(loginEntity);
			EmployeeEntity employeeEntity=new EmployeeEntity();
			employeeEntity.setEmpEmailID(formun);
			username=employeeService.getEmployeeName(employeeEntity);

			if(result.equalsIgnoreCase("success")){
				session.setAttribute("currentusername", username);
				session.setAttribute("UserEmailId",formun);
			
				if(userrole.equalsIgnoreCase("Admin")){
				RequestDispatcher dispatcher = request.getRequestDispatcher(ADMINLOGINSUCCESS);
				dispatcher.forward(request, response);
				}else{
				RequestDispatcher dispatcher=request.getRequestDispatcher(EMPLOYEELOGINSUCCESS);
				dispatcher.forward(request,response);
				}
				
			}else{
				session.setAttribute("error", "Login failed please check your credentials!!");
				RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR);
				dispatcher.forward(request, response);
			}
		}catch(Exception e){
			session.setAttribute("error", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR);
			dispatcher.forward(request, response);
		}
		}
			
		
		
	
}
