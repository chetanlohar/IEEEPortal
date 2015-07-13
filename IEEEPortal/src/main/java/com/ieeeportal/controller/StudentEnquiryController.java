package com.ieeeportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ieeeportal.entity.CityEntity;
import com.ieeeportal.entity.StudentEntity;
import com.ieeeportal.service.StudentEnquiryService;
import com.ieeeportal.service.impl.StudentEnquiryServiceImpl;



public class StudentEnquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String ENQUIRYPAGE = "StudentEnquiry";
	List<CityEntity> listofCity;

	public StudentEnquiryController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("in StudentEnquiryController");
		String action = request.getParameter("action");

		HttpSession session = request.getSession();
		if (action.equalsIgnoreCase("showdata")) {

			JSONObject json = new JSONObject();

			JSONArray jsonarray = new JSONArray();

			StudentEnquiryServiceImpl enquiryfieldList = new StudentEnquiryServiceImpl();

			/*
			 * cityList = enquiryfieldList.cityList();
			 * 
			 * try { for(CityEntity city : cityList){ json = new JSONObject();
			 * json.put("cityName", city.getCityName()); jsonarray.put(json); }
			 * } catch (JSONException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

			/* listofCity = enquiryfieldList.cityList(); */
			session.setAttribute("cityList", enquiryfieldList.cityList());
			session.setAttribute("collegeList", enquiryfieldList.collegeList());
			session.setAttribute("domainList", enquiryfieldList.domainList());
			session.setAttribute("referenceList",
					enquiryfieldList.referenceList());

			RequestDispatcher requestDispatch = request
					.getRequestDispatcher(ENQUIRYPAGE);
			requestDispatch.forward(request, response);

		}

		if (action.equalsIgnoreCase("submitenquiry")) {

			try {
				JSONObject jsonobj = new JSONObject(
						request.getParameter("enquirydata"));

				System.out.println(jsonobj.toString());

				// String date = (String) jsonobj.get("enDate");
				// System.out.println("date is "+date);
				JSONArray jsonnamearray = (JSONArray) jsonobj.get("enName");
				JSONArray jsonemailarray = (JSONArray) jsonobj.get("enEmail");
				JSONArray jsoncontactarray = (JSONArray) jsonobj.get("enCont");
				JSONArray jsongenderarray = (JSONArray) jsonobj
						.get("enqGender");
				String date = jsonobj.getString("enDate");
				
				int cityID = Integer.parseInt(jsonobj.getString("enCity"));
				System.out.println("cityID is "+cityID);
				int collegeID = Integer.parseInt(jsonobj.getString("enClg"));
				String department = jsonobj.getString("enDept");
				int domainID = Integer.parseInt(jsonobj.getString("enDomain"));
				String technology = jsonobj.getString("enTech");
				String teamsz = jsonobj.getString("enTeamsz");
				int referenceID = Integer.parseInt(jsonobj.getString("enRef"));

				int teamsize = Integer.parseInt(teamsz);

				List<String> namelist = new ArrayList<>();
				List<String> emaillist = new ArrayList<>();
				List<String> contactlist = new ArrayList<>();
				List<String> genderlist = new ArrayList<>();

				for (int i = 0; i < jsonnamearray.length(); i++) {
					System.out.println("names are :"
							+ jsonnamearray.getString(i));

					namelist.add(jsonnamearray.getString(i));
				}

				for (int i = 0; i < jsonemailarray.length(); i++) {

					System.out.println("emails are :"
							+ jsonemailarray.getString(i));
					emaillist.add(jsonemailarray.getString(i));
				}

				for (int i = 0; i < jsoncontactarray.length(); i++) {

					System.out.println("contacts are :"
							+ jsoncontactarray.getString(i));
					contactlist.add(jsoncontactarray.getString(i));
				}

				for (int i = 0; i < jsongenderarray.length(); i++) {

					System.out.println("contacts are :"
							+ jsongenderarray.getString(i));
					genderlist.add(jsongenderarray.getString(i));
				}

				StudentEntity studenqbean = new StudentEntity();

				studenqbean.setEnquiryDate(date);
				studenqbean.setStudentCityId(cityID);;
				studenqbean.setStudentCollegeId(collegeID);;
				studenqbean.setStudentDepartment(department);
				studenqbean.setStudentDomainId(domainID);
				studenqbean.setStudentTechnology(technology);
				studenqbean.setStudentTeamsize(teamsize);
				studenqbean.setStudentReferenceId(referenceID);
				studenqbean.setStudentNameList(namelist);
				studenqbean.setStudentEmailList(emaillist);
				studenqbean.setStudentContactList(contactlist);
				studenqbean.setStudentGenderList(genderlist);

				StudentEnquiryService studenqServiceImpl = new StudentEnquiryServiceImpl();

				String EnquirySuccess = studenqServiceImpl.studentEnquiryDetails(studenqbean);

				if(EnquirySuccess.equalsIgnoreCase("inserted")) {
					
				
					
					
					
					final String username = "softinfology15@gmail.com";
					final String password = "softinfology2015";
			 
			for(String emails:emaillist){	
				
				
					Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");
			 
					Session session1 = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					  });
			 
					try {
			 
					
						Message message = new MimeMessage(session1);
						message.setFrom(new InternetAddress(username));
						message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(emails));
						message.setSubject("Regards");
						message.setText("Thank You for enquiring at softinfology");

			 
						Transport.send(message);
			 
						System.out.println("Done");
			 
					} catch (MessagingException e) {
						throw new RuntimeException(e);
					}
				
			}		
					
					
					
					
					
					
					
					
					
					
					
					/*					
					session.setAttribute("UserEmails",emaillist);
					
					RequestDispatcher requestdispatcher = request.getRequestDispatcher("/SendMailAttachServlet");
					requestdispatcher.forward(request, response);
					
					EmailUtil emailobj = new EmailUtil();
				
					emailobj.sendEmail(studEmailbean);
					*/
				}
				
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
