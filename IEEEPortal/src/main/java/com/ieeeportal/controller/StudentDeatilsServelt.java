package com.ieeeportal.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class StudentDeatils
 */
public class StudentDeatilsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeatilsServelt() {
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
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		System.out.println("1 in " +name);
		HttpSession session=request.getSession();
		
	StudentDetailsService detailsService=new StudentDeatilsServiceImpl();
	ArrayList<StudentDetailsEntity> detailsEntity=new ArrayList<StudentDetailsEntity>();
	detailsEntity=detailsService.getStudent(name);
	session.setAttribute("srchstud", detailsEntity);

	System.out.println("Student details are: "+detailsEntity);
	RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/student/SerachStudent.jsp");

	rd.forward(request, response);
	
	}

}
