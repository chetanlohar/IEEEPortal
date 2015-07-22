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
import com.ieeeportal.service.impl.StudentEnquiryServiceImpl;

/**
 * Servlet implementation class ProjectListServlet
 */
public class ProjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DOMAINPAGE = "domain";
	StudentEnquiryServiceImpl enquiryfieldList = null;
	ProjectListService projectListService = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectListServlet() {
		super();
		enquiryfieldList = new StudentEnquiryServiceImpl();
		projectListService = new ProjectListImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = null;

		action = request.getParameter("action");

		System.out.println("Action is :" + action);
		if (action.equalsIgnoreCase("selectdomain")) {
			System.out.println("in selectdomain");
			session.setAttribute("domainList", enquiryfieldList.domainList());
			/*
			 * if (session.getAttribute("domainList") != null) {
			 */
			if (session.getAttribute("dName") != null) {
				session.removeAttribute("dName");
			}

			session.removeAttribute("prjlist");
			RequestDispatcher rd = request.getRequestDispatcher(DOMAINPAGE);
			rd.forward(request, response);
			/* } */
		}
		if (action.equalsIgnoreCase("domainpapers")) {
			System.out.println("in domainpapers");
			int domainid = Integer.parseInt(request.getParameter("dom"));
			ArrayList<ProjectDetailEntity> projectDetailList = new ArrayList<ProjectDetailEntity>();
			projectDetailList = projectListService.getProjectList(domainid);
			String domainName = null;
			for (ProjectDetailEntity pde : projectDetailList) {
				domainName = pde.getPrjdom();
				break;
			}

			session.setAttribute("dName", domainName);
			session.setAttribute("prjlist", projectDetailList);
			RequestDispatcher rd = request.getRequestDispatcher(DOMAINPAGE);
			rd.forward(request, response);
		}
		/*
		 * String domain = request.getParameter("domain");
		 * 
		 * session.setAttribute("domain", domain); else {
		 * ArrayList<ProjectDetailEntity> projectDetailList = new
		 * ArrayList<ProjectDetailEntity>(); ProjectListService
		 * projectListService = new ProjectListImpl(); projectDetailList =
		 * projectListService.getProjectList(); session = request.getSession();
		 * session.setAttribute("prjlist", projectDetailList);
		 * 
		 * RequestDispatcher rd = request
		 * .getRequestDispatcher("WEB-INF/jsp/project/domain.jsp");
		 * 
		 * rd.forward(request, response);
		 * 
		 * System.out.println("Project details:" + projectDetailList); }
		 */
	}

}
