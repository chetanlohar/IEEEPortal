package com.ieeeportal.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpenFileServlet
 */
public class OpenFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DOMAINPAGE = "domain";
	static String target;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OpenFileServlet() {
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
  
		String action = request.getParameter("action");
		String target = null;
		if (action.equalsIgnoreCase("abstract")) {
			String path = request.getParameter("path").toString();
		
			String newpath = path.concat(".doc");
	
			
			  try {
			      Desktop desktop = null;
			      if (Desktop.isDesktopSupported()) {
			        desktop = Desktop.getDesktop();
			      }

			       desktop.open(new File(newpath));
			       RequestDispatcher rd = request.getRequestDispatcher(DOMAINPAGE);
					rd.forward(request, response);

			    } catch (IOException ioe) {
			      ioe.printStackTrace();
			    }
			
			
		}
		if (action.equalsIgnoreCase("basepaper")) {
			String path = request.getParameter("path").toString();
			String newpath = path.concat(".pdf");
		
			  try {
			      Desktop desktop = null;
			      if (Desktop.isDesktopSupported()) {
			        desktop = Desktop.getDesktop();
			        
			      }

			       desktop.open(new File(newpath));
			       RequestDispatcher rd = request.getRequestDispatcher(DOMAINPAGE);
					rd.forward(request, response);

			    } catch (IOException ioe) {
			      ioe.printStackTrace();
			    }
		}

	}
	
}
