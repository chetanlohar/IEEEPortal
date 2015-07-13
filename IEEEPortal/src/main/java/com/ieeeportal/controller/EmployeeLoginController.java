package com.ieeeportal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ieeeportal.entity.LoginEntity;
import com.ieeeportal.service.LoginService;
import com.ieeeportal.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class EmployeeLoginController
 */
public class EmployeeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final String ADMINLOGINSUCCESS = "/WEB-INF/jsp/admin/adminhome.jsp";
    private static final String LOGINFAILURE = "login";
    public EmployeeLoginController() {
        super();
        // TODO Auto-generated constructor stub
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
		
		
		ServletContext context = request.getServletContext();
		HttpSession session = request.getSession();
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
		
		if(result.equalsIgnoreCase("success")){
			session.setAttribute("currentusername", adminun);
			RequestDispatcher dispatcher = request.getRequestDispatcher(ADMINLOGINSUCCESS);
			dispatcher.forward(request, response);
		}else{
			session.setAttribute("loginfailuremsg", "Login failed please check your credentials!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher(LOGINFAILURE);
			dispatcher.forward(request, response);
		}
	}

}
