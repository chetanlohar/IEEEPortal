package com.ieeeportal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ieeeportal.entity.StudentEnquiryEntity;
import com.ieeeportal.service.impl.StudentEnquiryServiceImpl;

@WebServlet("/StudentEnquiryController")
public class StudentEnquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		try {
			JSONObject jsonobj = new JSONObject(request.getParameter("enquirydata"));
			/*System.out.println(jsonobj.get("enName"));*/
			JSONArray jsonarray = (JSONArray) jsonobj.get("enName"); 
			for(int i=0;i<jsonarray.length();i++)
			System.out.println(jsonarray.getString(i));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

		/*
		 * String jstr = request.getParameter("enDate"); String jstr1 =
		 * request.getParameter("enCity");
		 * 
		 * String jstr2 = request.getParameter("enCollege"); String jstr4 =
		 * request.getParameter("enqDept"); String jstr5 =
		 * request.getParameter("enqDomain"); String jstr6 =
		 * request.getParameter("enqTech"); String jstr7 =
		 * request.getParameter("enqTeamSz");
		 * 
		 * 
		 * 
		 * 
		 * System.out.println(jstr+" "+jstr1+" "+jstr2+" "+jstr4+" "+jstr5+" "+jstr6
		 * +" "+jstr7);
		 */
		/*StudentEnquiryEntity studentEnquiryEntity = new StudentEnquiryEntity();
		List<String> list = new ArrayList<String>();
		// String[] contactlist=request.getParameter("enqcntno");
		// String[] contactlist=request.getParameter("enqcntno");
		list.add(request.getParameter("enqName"));
		list.add(request.getParameter("enqEmail"));
		list.add(request.getParameter("enqcntno"));
		Enumeration<String> str = request.getParameterNames();
		System.out
				.println("all data parameters" + str.nextElement().toString());

		JSONObject jObj = new JSONObject();
		JSONObject newObj = null;
		try {
			newObj = jObj.getJSONObject(request.getParameter("test"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator eNames = newObj.keys(); // gets all the keys

		while (eNames.hasNext()) {
			// Here I need to retrieve the values of the JSON string
			// and add it to the session

			String key = (String) eNames.next(); // get key
			try {
				Object o = jObj.get(key);

				System.out.println("obj " + o);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // get value
		}

		// System.out.println("date "+request.getParameter("enDate"));
		// System.out.println("name is "+request.getParameter("enName"));

		studentEnquiryEntity.setEnquiryDate(request.getParameter("enDate"));
		studentEnquiryEntity.setStudentCity(request.getParameter("enCity"));
		studentEnquiryEntity.setStudentCollege(request
				.getParameter("enCollege"));
		studentEnquiryEntity.setStudentDepartment(request
				.getParameter("enDept"));
		studentEnquiryEntity.setStudentDomain(request.getParameter("enDomain"));
		studentEnquiryEntity.setStudentTechnology(request
				.getParameter("enTech"));
		// studentEnquiryEntity.setStudentTeamsize(Integer.parseInt(request.getParameter("enTeamSz")));
		// studentEnquiryEntity.setStudentNameList();
		StudentEnquiryServiceImpl enquiryServiceImpl = new StudentEnquiryServiceImpl();
		enquiryServiceImpl.studentEnquiryDetails(studentEnquiryEntity);*/

		/*
		 * 
		 * System.out.println(jstr+" "+jstr1+" "+jstr2+" "+jstr4+" "+jstr5+" "+jstr6
		 * +" "+jstr7);
		 * 
		 * Enumeration en = request.getParameterNames();
		 * 
		 * while(en.hasMoreElements()){
		 * 
		 * String paramName = (String)en.nextElement();
		 * 
		 * String [] paramValues = request.getParameterValues(paramName);
		 * 
		 * for(String pv:paramValues){ System.out.println("value "+pv);
		 * 
		 * 
		 * }
		 * 
		 * 
		 * }
		 */

	}

}
