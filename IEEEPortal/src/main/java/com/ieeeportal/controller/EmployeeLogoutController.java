package com.ieeeportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EmployeeLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR="error";

	public EmployeeLogoutController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		try{
		
		String action = request.getParameter("action");
        
		if (action.equalsIgnoreCase("signout")) {
			session.removeAttribute("currentusername");
			response.sendRedirect("login"); // No logged-in user found, so
												// redirect to login page.
		}

		}catch(Exception e){
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher(ERROR);
			rd.forward(request, response);
			
		}
	}

}
