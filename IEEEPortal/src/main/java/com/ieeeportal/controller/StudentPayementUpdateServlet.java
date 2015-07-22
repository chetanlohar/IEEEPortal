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
 * Servlet implementation class StudentPayementUpdateServlet
 */
public class StudentPayementUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentPayementUpdateServlet() {
		super();
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
		System.out.println("grp id is:" + request.getParameter("grpid"));
		String grpid = request.getParameter("grpid");
		System.out.println("1 in " + grpid);
		HttpSession session = request.getSession();
		session.removeAttribute("msg");
		StudentDetailsService detailsService = new StudentDeatilsServiceImpl();
		List<StudentDetailsEntity> detailsEntity = detailsService.getStudent(grpid);
		session.setAttribute("srchstud", detailsEntity);

		System.out.println("Student details are: " + detailsEntity);

		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/jsp/student/StudentPayementUpdate.jsp");

		rd.forward(request, response);
		
	}

}
