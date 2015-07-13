package com.ieeeportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ieeeportal.service.impl.UpdateStudentPaymenrServiceImpl;

/**
 * Servlet implementation class UpdatePayementServlet
 */
public class UpdatePayementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePayementServlet() {
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
		HttpSession session=request.getSession();
	String grpid=request.getParameter("grpid");
	String amt=request.getParameter("paidamt");
	String empid=request.getParameter("empid");
	boolean res;
	UpdateStudentPaymenrServiceImpl paymenrServiceImpl=new UpdateStudentPaymenrServiceImpl();
	res=paymenrServiceImpl.updateStudpayment(grpid, empid, amt);
	
		session.removeAttribute("srchstud");
		
if(res)
{
session.setAttribute("msg", "Updated Successfully");
}
else
{
session.setAttribute("msg", "Please try again,enter valid employee id");

}

RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/student/StudentPayementUpdate.jsp");
rd.forward(request, response);
	}

}
