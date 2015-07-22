package com.ieeeportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.service.StudentDetailsService;
import com.ieeeportal.service.impl.StudentDeatilsServiceImpl;

/**
 * Servlet implementation class ProjectRequirements
 */
public class ProjectRequirements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectRequirements() {
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
		
		
		String groupID = request.getParameter("groupID");
		
		System.out.println("Group id is : "+groupID);
		
		HttpSession session = request.getSession();
		
		StudentDetailsService studentdetailService = new StudentDeatilsServiceImpl();
		
		List<StudentDetailsEntity> studDetailsEntity = new ArrayList<StudentDetailsEntity>();
		studDetailsEntity = studentdetailService.getStudent(groupID);
		
		session.setAttribute("students",studDetailsEntity);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/project/ProjectRequirement.jsp");
		
		requestDispatcher.forward(request, response);
		
	}

}
