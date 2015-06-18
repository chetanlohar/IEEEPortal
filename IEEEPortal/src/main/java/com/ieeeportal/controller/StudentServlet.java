package com.ieeeportal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ieeeportal.dao.impl.StudentDAOImpl;
import com.ieeeportal.entity.StudentRegistrationEntity;
import com.ieeeportal.util.RandomGenUtil;

/**
 * Servlet implementation class StudentRegistrationServlet for registering student 
 */
@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentRegistrationEntity studregent = null;
	StudentDAOImpl studDaoimpl = null;

	public StudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (studregent == null) {
			studregent = new StudentRegistrationEntity();
		}
		if (studDaoimpl == null) {
			studDaoimpl = new StudentDAOImpl();
		}
		//Generates random group Id 
		RandomGenUtil rgutil = new RandomGenUtil();
		
		studregent.setGrpid(rgutil.nextInt());
		studregent.setRegdate(request.getParameter("regdate"));
		studregent.setTech(request.getParameter("tch"));
		studregent.setTeamsz(Integer.parseInt(request.getParameter("teamsz")));
		studregent.setDept(request.getParameter("dept"));
		studregent.setStudstat("active");
		studregent.setTotfee(Double.valueOf(request.getParameter("totfees")));
		studregent.setDiscount(Double.valueOf(request.getParameter("dscamt")));
       
		studDaoimpl.insertRecord(studregent);
	}

}
