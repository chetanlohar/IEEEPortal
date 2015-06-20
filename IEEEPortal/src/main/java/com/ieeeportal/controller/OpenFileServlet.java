package com.ieeeportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpenFileServlet
 */
public class OpenFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenFileServlet() {
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

		String path = request.getParameter("path").toString();
		
		path=path.replace("\\", "\\\\");
		
		System.out.println("path:"+path);
		try {
			
			 
			    String cmd = "D:\\Reader11.0\\Reader\\AcroRd32.exe";
			    System.out.println("cmd /c start "+cmd+" "+ path);
				Runtime.getRuntime().exec("cmd /c start "+cmd+" "+path) ;
			    
			
	    }
		catch (IOException ex) {
			System.out.println("in catch"+ex.getMessage());
	    }
		
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/jsp/project/ProjectList.jsp");

		rd.forward(request, response);
		
	}
	}


