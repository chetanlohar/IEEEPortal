package com.ieeeportal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.ieeeportal.entity.ProjectDetailEntity;
import com.ieeeportal.service.ProjectListService;
import com.ieeeportal.service.impl.ProjectListImpl;

/**
 * Servlet implementation class ProjectListServlet
 */
public class ProjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String domain=request.getParameter("domain");

		session.setAttribute("domain", domain);

		if(session.getAttribute("prjlist") != null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/project/ProjectList.jsp");

			rd.forward(request, response);
		}
		else
		{
		ArrayList<ProjectDetailEntity> projectDetailList=new ArrayList<ProjectDetailEntity>();
	ProjectListService projectListService=new  ProjectListImpl();
	projectDetailList=projectListService.getProjectList();
	 session=request.getSession();
	session.setAttribute("prjlist", projectDetailList);

	RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/project/ProjectList.jsp");

	rd.forward(request, response);
	
	System.out.println("Project details:"+projectDetailList);
		}
	
	}

}
