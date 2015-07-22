package com.ieeeportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ieeeportal.entity.ProjectRequirementsEntity;
import com.ieeeportal.service.ProjectListService;
import com.ieeeportal.service.impl.ProjectListImpl;

/**
 * Servlet implementation class UpdateRequirements
 */
public class UpdateProjectRequirements extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private String ADMINHOME = "WEB-INF/jsp/admin/adminhome.jsp";
    
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProjectRequirements() {
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
		
		
		
		System.out.println("I am in project requirements servlet");
		
		HttpSession session = request.getSession();
		
		int groupID = Integer.parseInt(request.getParameter("grpid"));
		
		System.out.println("group id is :"+groupID );
		
		String requirements = request.getParameter("requirement");
		
		
		System.out.println("Requirements are : "+requirements);
		
		String dateOfRequirements = request.getParameter("date");
		
		System.out.println("Todays date is :"+dateOfRequirements);
		
		
		ProjectRequirementsEntity projReqEntity = new ProjectRequirementsEntity();
		
		
		projReqEntity.setGroupId(groupID);
		projReqEntity.setRequirements(requirements);
		projReqEntity.setDateOfRequirements(dateOfRequirements);
		
		
		ProjectListService projectRequirements = new ProjectListImpl();
		
		String result = projectRequirements.addRequirements(projReqEntity);
		
		if("inserted".equalsIgnoreCase(result)){
			
			
		//	session.setAttribute("msg", "Requirements stored successfully !!!");
			
			System.out.println("requirements persisted successfully");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(ADMINHOME);
			
			requestDispatcher.forward(request, response);
		
			
		}
		
		
	}

}
