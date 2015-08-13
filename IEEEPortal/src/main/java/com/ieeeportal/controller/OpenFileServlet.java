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

import org.json.JSONObject;

import com.ieeeportal.service.ProjectListService;
import com.ieeeportal.service.impl.ProjectListImpl;

/**
 * Servlet implementation class OpenFileServlet
 */
public class OpenFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DOMAINPAGE = "StudentEnquiryDomain";
	static String target;
	boolean flag = false;
	ProjectListService projListservice = null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OpenFileServlet() {
		super();
		projListservice = new ProjectListImpl();
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
			
			JSONObject jsonObject = new JSONObject(request.getParameter("FileID").trim());
		       String fileId=(String)jsonObject.get("ID");
			 //String fileId = request.getParameter("FileID").trim();
		         System.out.println(" file path"+fileId);
		    
		         String filepath = projListservice.openFile(fileId);
		         System.out.println("Filepath is:"+filepath);
			     
		         String newpath = filepath.concat(".doc");
	
			
			  try {
			      Desktop desktop = null;
			      if (Desktop.isDesktopSupported()) {
			        desktop = Desktop.getDesktop();
			        desktop.open(new File(newpath));
				       flag = true;
			      }
			     } catch (Exception ioe) {
			      ioe.printStackTrace();
			    }
			if(flag){
				response.getWriter().print("Success");
				
			}
			
		}
		else if (action.equalsIgnoreCase("basepaper")) {
			JSONObject jsonObject = new JSONObject(request.getParameter("FileID").trim());
		       String fileId=(String)jsonObject.get("ID");
			 //String fileId = request.getParameter("FileID").trim();
		         System.out.println(" file path"+fileId);
		    
		         String filepath = projListservice.openFile(fileId);
		         System.out.println("Filepath is:"+filepath);
			     
		         String newpath = filepath.concat(".pdf");
	
			
			  try {
			      Desktop desktop = null;
			      if (Desktop.isDesktopSupported()) {
			        desktop = Desktop.getDesktop();
			        desktop.open(new File(newpath));
				       flag = true;
			      }
			     } catch (Exception ioe) {
			      ioe.printStackTrace();
			    }
			if(flag){
				response.getWriter().print("Success");
				
			}
		}
	}
	
}
