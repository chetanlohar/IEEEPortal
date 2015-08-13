package com.ieeeportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.EmployeeEntity;
import com.ieeeportal.entity.PaperEntity;
import com.ieeeportal.entity.ProjectDetailEntity;
import com.ieeeportal.service.EmployeeRegistrationService;
import com.ieeeportal.service.ProjectListService;
import com.ieeeportal.service.StudentEnquiryService;
import com.ieeeportal.service.impl.EmployeeRegisterServiceImpl;
import com.ieeeportal.service.impl.ProjectListImpl;
import com.ieeeportal.service.impl.StudentEnquiryServiceImpl;

/**
 * Servlet implementation class AdminProjectAssignmentController
 */

public class AdminProjectAssignmentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	List<DomainEntity> domainList;
	List<EmployeeEntity> empList;
	List<EmployeeEntity> empNameList;
	DomainEntity domainEntity;
	ProjectListService projectListService;
	EmployeeRegistrationService employeeRegistrationService;
	int domainId, paperID, empId;
	StudentEnquiryService studentEnquiryService;
	 private static final String ERROR = "error";
	ProjectDetailEntity projectDetailEntity = new ProjectDetailEntity();
	public AdminProjectAssignmentController() {
		super();

		this.domainList = null;
		this.empList = null;
		this.projectListService = new ProjectListImpl();
		this.employeeRegistrationService = new EmployeeRegisterServiceImpl();
		this.domainId = 0;
		this.paperID = 0;
		this.empId = 0;
		this.studentEnquiryService = new StudentEnquiryServiceImpl();
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
try{
		String action = request.getParameter("action");
		System.out.println(" Action " + action);

		switch (action) {
		case "showData":
			domainEntity = new DomainEntity();
			empNameList = new ArrayList<EmployeeEntity>();
			domainList = studentEnquiryService.domainList();
			session.setAttribute("DomainNames", domainList);
			empList = employeeRegistrationService.getEmployeeRecords();
			for (EmployeeEntity empRecordList : empList) {

				System.out.println(" emp name  and its designation "
						+ empRecordList.getEmpName() + " "
						+ empRecordList.getEmpdesignation());
				if ((empRecordList.getEmpdesignation()
						.equalsIgnoreCase("JavaDeveloper"))
						|| (empRecordList.getEmpdesignation()
								.equalsIgnoreCase("WebDesigner"))) {
					EmployeeEntity employeeEntity = employeeEntity = new EmployeeEntity();
					employeeEntity.setEmpID(empRecordList.getEmpID());
					employeeEntity.setEmpName(empRecordList.getEmpName());
					empNameList.add(employeeEntity);
					session.setAttribute("EmpNameList", empNameList);
				}
			}
             
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/jsp/admin/projectAssignment.jsp");
			dispatcher.forward(request, response);
			break;

		case "showPaper":
			System.out.println(" hi from ajax reuest");
			try {
				JSONObject jsonObject = new JSONObject(request.getParameter(
						"domainData").trim());
				System.out.println(" data from ajax" + jsonObject.toString());
				String domainName = (String) jsonObject.get("domainID");
				domainId = Integer.parseInt(domainName);
				System.out.println(" domainId in con troller through json "
						+ domainId);
				List<ProjectDetailEntity> paperList = projectListService
						.getProjectList(domainId);
				System.out.println("size of list is:" + paperList.size());
				session.setAttribute("papernames", paperList);
				jsonObject.put("papernamelist", paperList);
				JSONArray jarry = new JSONArray(paperList);
				System.out.println(jarry);
				response.getWriter().print(jarry);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "submit":
			boolean flag=false;
			System.out.println(" In submit action");
			JSONObject jsonObj = new JSONObject(
					request.getParameter("projectAssignmentData"));
			System.out.println(" data from assignment in json "
					+ jsonObj.toString());
			domainId = jsonObj.getInt("domainID");
			paperID = jsonObj.getInt("paperID");
			empId = jsonObj.getInt("employeeID");

			System.out.println("domainId " + domainId + " paperID " + paperID
					+ " empId " + empId);
			projectDetailEntity.setEmpId(empId);
			projectDetailEntity.setPrjid(paperID);
			projectDetailEntity.setDomainId(domainId);
			flag = projectListService.assignProject(projectDetailEntity);
			if (flag == true) {
				System.out
						.println(" In AdminProjectAssignmentController of flag");
				List<ProjectDetailEntity> assignRecordList= projectListService
						.getProjectAssigned(projectDetailEntity);

				for (ProjectDetailEntity listOfAssign : assignRecordList) {

					System.out
							.println(" I am in assignment controller and value of assign product is \n");
					System.out.println("\nEmpName " + listOfAssign.getEmpName()
							+ "\n Domain Name" + listOfAssign.getPrjdom()
							+ " \nPaperName" + listOfAssign.getPrjtitle()
							+ "\ntime stamp" + listOfAssign.getDateOfAssign());
				}
				
				JSONObject jObj = new JSONObject();
				jObj.put("AssignRecords",assignRecordList);  
				  System.out.println(jObj);
				  response.getWriter().print(jObj);
				 
			}


			break;

		default:
			break;
		}

}catch(Exception e){
	session.setAttribute("error", e.getMessage());
	RequestDispatcher rd=request.getRequestDispatcher(ERROR);
	rd.forward(request, response);
}
}

}
