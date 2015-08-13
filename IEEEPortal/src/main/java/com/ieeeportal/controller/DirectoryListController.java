package com.ieeeportal.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DirectoryListController
 */
public class DirectoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String DOMAINPAGE = "WEB-INF/jsp/project/domain1.jsp";
	private static final String ERROR="error";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectoryListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try{
		System.out.println("I am in servlet");
		 int domId = Integer.parseInt(request.getParameter("domain"));
	}
	catch(Exception e){
		session.setAttribute("error", e.getMessage());
		RequestDispatcher rd=request.getRequestDispatcher(ERROR);
		rd.forward(request, response);
	}
	}

}
