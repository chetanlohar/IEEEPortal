package com.ieeeportal.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DirectoryListController
 */
public class DirectoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String DOMAINPAGE = "WEB-INF/jsp/project/domain1.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectoryListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("I am in servlet");
		
		HttpSession session = request.getSession();
		
		
		 int domId = Integer.parseInt(request.getParameter("domain"));

		
		 
		
		
		
		
		
		
	/*	String str = "D:\\IEEE2015\\"+str1;
		
		File directory  =  new File(str);
			
			
			File [] fileList = directory.listFiles();
			
			List<String> abstractList = new ArrayList<String>();
			List <String> paperList = new ArrayList<String>();
			
			for(File file:fileList){
				
				if(file.getName().endsWith(".docx")||file.getName().endsWith(".doc")){
					
				//	System.out.println("Abstract is  : "+file.getName());
					abstractList.add(file.getName());
				}
				else{
					
				//	System.out.println("Base paper is : "+file.getName());
					paperList.add(file.getName());
				}
		
				
			}
			System.out.println("Abstract list size is : "+abstractList.size());
			System.out.println("Abstract List is: "+abstractList);
			
			System.out.println("Base Paper list size is : "+paperList.size());
			System.out.println("Base Paper List is: "+paperList);
			
			
			session.setAttribute("abstracts",abstractList);
			session.setAttribute("papers",paperList);
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(DOMAINPAGE);
			requestDispatcher.forward(request, response);
*/			

	}

}
