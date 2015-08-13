package com.ieeeportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ieeeportal.entity.CityEntity;
import com.ieeeportal.entity.CollegeEntity;
import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.PaperEntity;
import com.ieeeportal.entity.ProjectDetailEntity;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;
import com.ieeeportal.service.ProjectListService;
import com.ieeeportal.service.impl.ProjectListImpl;
import com.ieeeportal.service.impl.StudentEnquiryServiceImpl;
import com.ieeeportal.service.impl.StudentRegistrationServiceImpl;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

/**
 * Servlet implementation class StudentRegistrationController
 */
public class StudentRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String STUDENTREGFORM = "StudentRegistrationForm";
    private static final String REGISTEREDSTUDENTPAGE="RegisteredStudent";
    StudentEnquiryServiceImpl enquiryfieldService = null;
    StudentRegistrationServiceImpl sregService = null;
    ProjectListService projectListService=null;
     StudentEntity studententity = null; 
     List<StudentDetailsEntity> registeredStudent;
     List<CollegeEntity>collegeList;
     CollegeEntity collegeEntity;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistrationController() {
        super();
        enquiryfieldService = new StudentEnquiryServiceImpl();
        sregService = new StudentRegistrationServiceImpl();
        projectListService=new ProjectListImpl();
        studententity = new StudentEntity(); 
        this.registeredStudent=null;
        this.collegeList=null;
        this.collegeEntity=null;
     
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(" action "+action);
		HttpSession session = request.getSession();
		List<DomainEntity> domainList = new ArrayList<DomainEntity>();
		DomainEntity domainEntity = new DomainEntity();
		ProjectListService projectListService = new ProjectListImpl();
		int domainId=0;
		List<StudentDetailsEntity> spersdetailslist = new ArrayList<StudentDetailsEntity>();
		if(action.equalsIgnoreCase("register")){
			int enquiryId = Integer.parseInt(request.getParameter("enqid"));
			session.setAttribute("enquiryid", enquiryId);
			List<StudentDetailsEntity> listOftoregStudent = sregService.studentList(enquiryId);
			for(StudentDetailsEntity sde :listOftoregStudent){
				StudentDetailsEntity sdeobj = new StudentDetailsEntity();
				sdeobj.setStdname(sde.getStdname());
				sdeobj.setEmailid(sde.getEmailid());
				sdeobj.setPhoneno(sde.getPhoneno());
				sdeobj.setGender(sde.getGender());
				spersdetailslist.add(sdeobj);
			}
			session.setAttribute("cityList", enquiryfieldService.cityList());
			session.setAttribute("collegeList", enquiryfieldService.collegeList());
			session.setAttribute("domainList", enquiryfieldService.domainList());
			session.setAttribute("referenceList", enquiryfieldService.referenceList());
			session.setAttribute("studenttoreg", listOftoregStudent);
			session.setAttribute("studpersonaldet", spersdetailslist);
			RequestDispatcher dispatcher = request.getRequestDispatcher(STUDENTREGFORM);
			dispatcher.forward(request, response);
		}
		
		else if (action.equalsIgnoreCase("showPaper")) {
			
			try {
				System.out.println(" i am in show paper of registration controller ");
				JSONObject jsonObject = new JSONObject(request.getParameter("domainData").trim());
				System.out.println(" data from ajax" + jsonObject.toString());
				String domainName = (String) jsonObject.get("domainId");
				 domainId=Integer.parseInt(domainName); 
				System.out.println(" domainId in con troller through json "
						+ domainId);
				/*domainEntity.setDomainId(domainId);
				List<PaperEntity> paperList = projectListService.getPapersName(domainEntity);
				*/
				List<ProjectDetailEntity> paperList=projectListService.getProjectList(domainId);
				
				System.out.println("size of list is:"+paperList.size());
				session.setAttribute("papernames", paperList);
				jsonObject.put("papernamelist",paperList);
				JSONArray jarry = new JSONArray(paperList);
				System.out.println(jarry);
				response.getWriter().print(jarry);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equalsIgnoreCase("registerstudent")){
			JSONObject jsonobj = new JSONObject(request.getParameter("registerdata").trim());
			JSONArray jsonnamearray = (JSONArray) jsonobj.get("enName");
			System.out.println("JsonArray"+jsonnamearray);
			JSONArray jsonemailarray = (JSONArray) jsonobj.get("enEmail");
			JSONArray jsoncontactarray = (JSONArray) jsonobj.get("enCont");
			JSONArray jsongenderarray = (JSONArray) jsonobj.get("enqGender");
			String date = jsonobj.getString("enDate");
			
			
			
			System.out.println("jsonemailarray is : "+jsonemailarray);
			System.out.println("jsoncontactarray is : "+jsoncontactarray);
			System.out.println("jsongenderarray is : "+jsongenderarray);
			
			
			int cityID = Integer.parseInt(jsonobj.getString("enCity"));
			
			int collegeID = Integer.parseInt(jsonobj.getString("enClg"));
			String department = jsonobj.getString("enDept");
			int domainID = Integer.parseInt(jsonobj.getString("enDomain"));
			String technology = jsonobj.getString("enTech");
			int referenceID = Integer.parseInt(jsonobj.getString("enRef"));
			int teamsize = Integer.parseInt(jsonobj.getString("enTeamsz"));
			
			
			
			String papertitle = jsonobj.getString("paperlist");
			int totalfees = Integer.parseInt(jsonobj.getString("totalfees"));
			int discount = Integer.parseInt(jsonobj.getString("discount"));
			
			
			List<String> namelist = new ArrayList<>();
			List<String> emaillist = new ArrayList<>();
			List<String> contactlist = new ArrayList<>();
			List<String> genderlist = new ArrayList<>();

			for (int i = 0; i < jsonnamearray.length(); i++) {
				System.out.println("names are :"
						+ jsonnamearray.getString(i));

				namelist.add(jsonnamearray.getString(i));
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

				System.out.println("gender are :"
						+ jsongenderarray.getString(i));
				genderlist.add(jsongenderarray.getString(i));
			}
			studententity.setEnquiryId(Integer.parseInt(session.getAttribute("enquiryid").toString()));
			studententity.setRegDate(date);
			studententity.setStudentCityId(cityID);
			studententity.setStudentCollegeId(collegeID);
			studententity.setStudentDepartment(department);
			studententity.setStudentDomainId(domainID);
			studententity.setStudentTechnology(technology);
			studententity.setStudentTeamsize(teamsize);
			studententity.setStudentReferenceId(referenceID);
			studententity.setProjecttitle(papertitle);
			studententity.setTotalfee(totalfees);
			studententity.setDiscount(discount);
			studententity.setStudentNameList(namelist);
			studententity.setStudentEmailList(emaillist);
			studententity.setStudentContactList(contactlist);
			studententity.setStudentGenderList(genderlist);
            
			String status = sregService.insertRegistrationRecord(studententity);
			if(status.equalsIgnoreCase("Success")){
				System.out.println("Registration success!");
				int grpid = sregService.getGrpId();
				
				
				
				
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
						message.setText("Your Group id is: "+"GRP#"+grpid+" Keep it Safe!!");

						Transport.send(message);

						System.out.println("Done");

					} catch (MessagingException e) {
						throw new RuntimeException(e);
					}

				}
			}
		}else if(action.equalsIgnoreCase("showCollegeName")){
		 
		
		System.out.println("College List.....");
		collegeList=enquiryfieldService.collegeList();
		session.setAttribute("listOfCollege",collegeList);
		RequestDispatcher rd=request.getRequestDispatcher(REGISTEREDSTUDENTPAGE);
		rd.forward(request,response);
		
		}else if(action.equalsIgnoreCase("showRegisteredStudent")){
			 
			JSONObject jsonObject=new JSONObject(request.getParameter("collegeData"));
			String collegeId=(String)jsonObject.get("CollegeId");
			System.out.println("CollegeId in Controller "+collegeId);
			 collegeEntity=new CollegeEntity();
			 collegeEntity.setCollegeId(Integer.parseInt(collegeId));
			
			System.out.println("Student Registered List.....");
			registeredStudent=sregService.registerStudent(collegeEntity);
			JSONObject jsObject=new JSONObject();
			jsObject.put("RegisteredStudentList",registeredStudent);
			System.out.println("Json Object"+jsObject.toString());
			response.setContentType("application/json");
			response.getWriter().print(jsObject);
		}
	}
}
