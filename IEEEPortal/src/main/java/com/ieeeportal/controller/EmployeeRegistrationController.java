package com.ieeeportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.Session;

import org.json.JSONException;
import org.json.JSONObject;

import com.ieeeportal.dao.impl.EmployeeDaoImpl;
import com.ieeeportal.entity.EmployeeEntity;
import com.ieeeportal.service.EmployeeRegistrationService;
import com.ieeeportal.service.impl.EmployeeRegisterServiceImpl;

/**
 * Servlet implementation class EmployeeRegistrationController
 */

public class EmployeeRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EmployeeRegister="/EmployeeRegistrationForm";
    boolean flag;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeRegistrationController() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println(" I am in controller");
		List<String> list=new ArrayList<String>();
	       HttpSession session=request.getSession();
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("showdata")){
		
			
			EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
			list=employeeDaoImpl.getEmployeeRecords();
		    session.setAttribute("EmpNameList",list);
		    RequestDispatcher rd=request.getRequestDispatcher(EmployeeRegister);
		    rd.forward(request, response);
		}
		
		if(action.equalsIgnoreCase("registerdata")){
		System.out.println("Hello from controller ");

		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(request.getParameter("empdata"));
			System.out.println("Data from json" + jsonObject.toString());
			String name = (String) jsonObject.get("empName");
			String emailID = (String) jsonObject.get("empEmailID");
			String password = (String) jsonObject.get("empPassword");
			String designation = (String) jsonObject.get("empDesignation");
			String contactNo = (String) jsonObject.get("empContactNo");
			String gender = (String) jsonObject.get("empGender");
			String dateOfJoinning = (String) jsonObject.get("empDOJ");
			System.out.println("Date of joining" + dateOfJoinning);
			String Address = (String) jsonObject.get("empAddress");
			String Role = (String) jsonObject.get("empRole");
			String reportingManager = (String) jsonObject.get("reportingManager");

			EmployeeEntity employee = new EmployeeEntity();
			employee.setEmpEmailID(emailID);
			employee.setEmpName(name);
			employee.setEmpPassword(password);
			employee.setEmpdesignation(designation);
			employee.setEmpContactNo(contactNo);
			employee.setEmpDateOfJoinning(dateOfJoinning);
			employee.setEmpAddress(Address);
			employee.setEmpRole(Role);
			employee.setEmpGender(gender);
            employee.setReportingManager(reportingManager);  
			
			try {
				EmployeeRegistrationService emImpl = new EmployeeRegisterServiceImpl();
				flag = emImpl.registerEmployee(employee);
				if(flag){
					final String username = "softinfology15@gmail.com";
					final String password1 = "softinfology2015";
			 		Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
			 
					javax.mail.Session session1 = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password1);
						}
					  });
			 
					try {
			 
					
						Message message = new MimeMessage(session1);
						message.setFrom(new InternetAddress(username));
						message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(emailID));
						message.setSubject("Regards");
						message.setText(employee.getEmpName()+"\n"+"you are Sucessfully Registered at Softinfology Pvt Ltd..");

			 
						Transport.send(message);
			 
						System.out.println("Mail Sent to employee!!");
			 
					} catch (MessagingException e) {
						throw new RuntimeException(e);
					}
					
				}
				
			
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
}