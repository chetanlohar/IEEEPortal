package com.ieeeportal.controller;

import java.io.File;
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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ieeeportal.entity.CityEntity;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;
import com.ieeeportal.service.StudentEnquiryService;
import com.ieeeportal.service.impl.StudentEnquiryServiceImpl;
import com.ieeeportal.util.SendpPayementReceipt;

public class StudentEnquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ENQUIRYPAGE = "StudentEnquiry";
	private static final String ENQUIREDPAGE = "StudentEnquiryDetails";
	private  static final String PAPERPATH="D:/DOMAINS"; 
	int domid;
	List<CityEntity> listofCity;
	StudentEnquiryServiceImpl enquiryfieldService = null;
	List<String> paperpathlist;

	public StudentEnquiryController() {
		super();
		enquiryfieldService = new StudentEnquiryServiceImpl();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
       
		
		System.out.println("in StudentEnquiryController");
		String action = request.getParameter("action");
		System.out.println("action is"+action);
	     ServletContext context=request.getServletContext();

		HttpSession session = request.getSession();
		if (action.equalsIgnoreCase("showdata")) {

			JSONObject json = new JSONObject();

			JSONArray jsonarray = new JSONArray();

			
			session.setAttribute("cityList", enquiryfieldService.cityList());
			session.setAttribute("collegeList", enquiryfieldService.collegeList());
			session.setAttribute("domainList", enquiryfieldService.domainList());
			session.setAttribute("referenceList", enquiryfieldService.referenceList());

			RequestDispatcher requestDispatch = request
					.getRequestDispatcher(ENQUIRYPAGE);
			requestDispatch.forward(request, response);

		}

		if (action.equalsIgnoreCase("submitenquiry")) {

			try {
				JSONObject jsonobj = new JSONObject(
						request.getParameter("enquirydata"));

				System.out.println(jsonobj.toString());

				
				JSONArray jsonnamearray = (JSONArray) jsonobj.get("enName");
				JSONArray jsonemailarray = (JSONArray) jsonobj.get("enEmail");
				JSONArray jsoncontactarray = (JSONArray) jsonobj.get("enCont");
				JSONArray jsongenderarray = (JSONArray) jsonobj.get("enqGender");
				JSONArray jsonSelectedPaerArray=(JSONArray)jsonobj.get("SelectedPapers");
				System.out.println(" array of papers"+jsonSelectedPaerArray.toString());
				String date = jsonobj.getString("enDate");

				int cityID = Integer.parseInt(jsonobj.getString("enCity"));
				System.out.println("cityID is " + cityID);
				int collegeID = Integer.parseInt(jsonobj.getString("enClg"));
				String department = jsonobj.getString("enDept");
				int domainID = Integer.parseInt(jsonobj.getString("enDomain"));
				String technology = jsonobj.getString("enTech");
				
				String nameofstudentfile=jsonobj.getString("studentfile");
				System.out.println(" name of student file"+nameofstudentfile);
				
				String filename=nameofstudentfile.substring(12);
				
				System.out.println(" \nnew filename is"+filename);
				
				File studentfile=new File(filename);
				System.out.println("\n absolute path"+studentfile.getAbsolutePath());
				
				
				
				String teamsz = jsonobj.getString("enTeamsz");
				int referenceID = Integer.parseInt(jsonobj.getString("enRef"));

				int teamsize = Integer.parseInt(teamsz);

				List<String> namelist = new ArrayList<>();
				List<String> emaillist = new ArrayList<>();
				List<String> contactlist = new ArrayList<>();
				List<String> genderlist = new ArrayList<>();
				List<String> paperlist=new ArrayList<String>();

				for (int i = 0; i < jsonnamearray.length(); i++) {
					System.out.println("names are :"
							+ jsonnamearray.getString(i));

					namelist.add(jsonnamearray.getString(i));
				}

				for (int i = 0; i < jsonSelectedPaerArray.length(); i++) {
					System.out.println("papers are :"
							+ jsonSelectedPaerArray.getString(i));

					paperlist.add(jsonSelectedPaerArray.getString(i));
				}
				if(emaillist.size()!=0){
					emaillist.clear();
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
				studenqbean.setStudentCityId(cityID);
				studenqbean.setStudentCollegeId(collegeID);
				studenqbean.setStudentDepartment(department);
				studenqbean.setStudentDomainId(domainID);
				studenqbean.setStudentTechnology(technology);
				studenqbean.setStudentTeamsize(teamsize);
				studenqbean.setStudentReferenceId(referenceID);
				studenqbean.setStudentNameList(namelist);
				studenqbean.setStudentEmailList(emaillist);
				studenqbean.setStudentContactList(contactlist);
				studenqbean.setStudentGenderList(genderlist);
				studenqbean.setStudentpaperList(paperlist);
               
				paperpathlist=enquiryfieldService.getPaperPath(studenqbean);
				
				for(String s:paperpathlist){
					System.out.println("In controller path is:"+s);
				}
				String EnquirySuccess = enquiryfieldService
						.studentEnquiryDetails(studenqbean);
				SendpPayementReceipt sendpPayementReceipt=new SendpPayementReceipt();
				sendpPayementReceipt.enquirymail(context,studenqbean,paperpathlist);

				if (EnquirySuccess.equalsIgnoreCase("inserted")) {

					final String username = "softinfology15@gmail.com";
					final String password = "softinfology2015";

					for (String emails : emaillist) {

						Properties props = new Properties();
						props.put("mail.smtp.auth", "true");
						props.put("mail.smtp.starttls.enable", "true");
						props.put("mail.smtp.host", "smtp.gmail.com");
						props.put("mail.smtp.port", "587");

						Session session1 = Session.getInstance(props,
								new javax.mail.Authenticator() {
									protected PasswordAuthentication getPasswordAuthentication() {
										return new PasswordAuthentication(
												username, password);
									}
								});

						try {

							Message message = new MimeMessage(session1);
							message.setFrom(new InternetAddress(username));
							message.setRecipients(Message.RecipientType.TO,
									InternetAddress.parse(emails));
							message.setSubject("Regards");
							message.setText("Thank You for enquiring at softinfology"
									+ "<br>"
									+ "<br>"
									+ "<img src=http://www.ieeeclass.com/images/image003.jpg > ");

							Transport.send(message);

							System.out.println("Done");

						} catch (MessagingException e) {
							throw new RuntimeException(e);
						}

					}
					
				}

			} catch (JSONException e) {
				
				e.printStackTrace();
			}

		}
		if (action.equalsIgnoreCase("showenquired")) {
            session.removeAttribute("enquiredstudentlist");
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(ENQUIREDPAGE);
			dispatcher.forward(request, response);

		}

		if(action.equalsIgnoreCase("showspenquired")){
			String sname = request.getParameter("name");
			
			
			List<StudentDetailsEntity> listOfSpEnqStudent = new ArrayList<StudentDetailsEntity>();
			
			 listOfSpEnqStudent = enquiryfieldService.enquiredSpStudentList(sname);
				
			session.setAttribute("enquiredstudentlist",listOfSpEnqStudent);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher(ENQUIREDPAGE);
			dispatcher.forward(request, response);
		}
		if(action.equalsIgnoreCase("showallenquired")){
			List<StudentDetailsEntity> listOfEnqStudent = new ArrayList<StudentDetailsEntity>();
			 listOfEnqStudent = enquiryfieldService.enquiredStudentList();
			 session.setAttribute("enquiredstudentlist",listOfEnqStudent);
			 RequestDispatcher dispatcher = request
						.getRequestDispatcher(ENQUIREDPAGE);
				dispatcher.forward(request, response);
		}
		
		if(action.equalsIgnoreCase("paperId")){
			JSONObject json = new JSONObject(request.getParameter("popupdomain"));
			 domid=json.getInt("popupId");
			System.out.println(" dom id: are mansa"+domid);
			
		}
		
		if(action.equalsIgnoreCase("uploadfile")){
	
			
			boolean ismultipart=ServletFileUpload.isMultipartContent(request);
            System.out.println("ismultipart"+ismultipart);
            /*if(ismultipart){*/
            	FileItemFactory factory=new DiskFileItemFactory();
            	ServletFileUpload upload=new ServletFileUpload(factory);
            	try{
            		
            		List<FileItem> multiparts=upload.parseRequest(request);
            		for(FileItem item:multiparts){
            			if(!item.isFormField()){
            				
            				String name=new File(item.getName()).getName();
            				
            				System.out.println(" file name"+item.getName());
            				
            				System.out.println(" file  full name"+PAPERPATH+File.separator+name);
            				
            				item.write(new File(PAPERPATH+File.separator+name));
            				
            			}
            			
            		}
            	}catch (Exception e) 
				{
  				  e.printStackTrace();
  				}
            	
            }
			
		}
	//}
			
			
}
