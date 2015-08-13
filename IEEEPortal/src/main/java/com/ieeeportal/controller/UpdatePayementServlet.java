package com.ieeeportal.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperRunManager;

import com.ieeeportal.service.impl.UpdateStudentPaymenrServiceImpl;
import com.ieeeportal.util.ConnectionFactory;

/**
 * Servlet implementation class UpdatePayementServlet
 */
public class UpdatePayementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con=ConnectionFactory.getConnection();
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
		String reportname="reciept_"+grpid+"_"+System.currentTimeMillis();
if(res)
{
	 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ReportServlet?para1=" + grpid + "&reportname=" + reportname+"&name="+"report5.jasper"+"&loc="+"WEB-INF/jsp/student/StudentPayementUpdate.jsp");
     dispatcher.forward(request, response);
	
	


}
else
{
	session.setAttribute("msg", "Please try again,enter valid employee id");
	RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/student/StudentPayementUpdate.jsp");
	rd.forward(request, response);
}


	}

}
