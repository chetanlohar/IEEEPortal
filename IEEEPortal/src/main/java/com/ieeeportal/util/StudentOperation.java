package com.ieeeportal.util;

import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.dao.StudentDAO;
import com.ieeeportal.dao.impl.StudentDAOImpl;
import com.ieeeportal.dao.impl.StudentEnquiryDAOImpl;
import com.ieeeportal.entity.StudentDetailsEntity;

public class StudentOperation 
{
	int i=0,grpid,enqid;
	static int flag,flag2;
	StudentDetailsEntity detailsEntity=new StudentDetailsEntity();
	List<StudentDetailsEntity> studentDetailsEntities=new ArrayList<StudentDetailsEntity>();
	
	List<StudentDetailsEntity> outlist=new ArrayList<StudentDetailsEntity>();
	
	
	StudentEnquiryDAOImpl studentEnquiryDAO = new StudentEnquiryDAOImpl();


	StudentDAO studentDAO=new StudentDAOImpl();
	public List<StudentDetailsEntity> getSpStudent(String name)
	{
		
		if(Comman.isNumeric(name))
		{
			getSpStudent(Integer.parseInt(name));
		}
		studentDetailsEntities=studentDAO.getAllStudentList();
		System.out.println("all student :"+studentDetailsEntities);
		for(StudentDetailsEntity detailsEntity:studentDetailsEntities)
		{
			if(flag==1)
			{
				if(grpid==detailsEntity.getGrpid())
				{
					outlist.add(detailsEntity);

				}
				
			}
			
			/*if(detailsEntity.getStdname().equalsIgnoreCase(name))
			{
				grpid=detailsEntity.getGrpid();
				
				
					outlist.add(detailsEntity);
				flag=1;
			}*/
			if(detailsEntity.getStdname().toLowerCase().contains(name.toLowerCase()))
			{
				grpid=detailsEntity.getGrpid();
				//System.out.println("in submath");
				
				outlist.add(detailsEntity);
			flag=1;
			}
					
		}
		
		return outlist;
		
		
	}
	
	public List<StudentDetailsEntity> getSpStudent(int mygrpid)
	{
		studentDetailsEntities=studentDAO.getAllStudentList();
		System.out.println("all student :"+studentDetailsEntities);
		for(StudentDetailsEntity detailsEntity:studentDetailsEntities)
		{
			
				if(mygrpid==detailsEntity.getGrpid())
				{
					outlist.add(detailsEntity);

				}
				
			
			
			
					
		}
		
		return outlist;
		
		
	}

	
	// for getting specific enquired student detatils
		public List<StudentDetailsEntity> getSpEnquiredStudentList(String name) {
			if (Comman.isNumeric(name)) {
				System.out.println("number");
			outlist=getSpEnquiredStudent(Integer.parseInt(name));
			return outlist;
				
			}
			else
			{
				outlist.clear();
			studentDetailsEntities = studentEnquiryDAO.enquiredStudentList();
			for (StudentDetailsEntity detailsEntity : studentDetailsEntities) {
			

				if (detailsEntity.getStdname().toLowerCase().contains(name.toLowerCase())) {
					enqid = detailsEntity.getEnqid();
					// System.out.println("in submath");

					outlist.add(detailsEntity);
					flag2 = 1;
				}
				else if (flag2 == 1) {
					
					if (enqid == detailsEntity.getEnqid()) {
						outlist.add(detailsEntity);

					}

				}

			} flag2=0;
			System.out.println("ret student :" + outlist.size());

			return outlist;
			}
			//return null;

		}

		public List<StudentDetailsEntity> getSpEnquiredStudent(int myenqid) {
			outlist.clear();
			
			studentDetailsEntities = studentEnquiryDAO.enquiredStudentList();
		//	System.out.println("all student :" + studentDetailsEntities);
			for (StudentDetailsEntity detailsEntity : studentDetailsEntities) {

				if (myenqid == detailsEntity.getEnqid()) {
					outlist.add(detailsEntity);

				}

			}
	System.out.println("ret  nuber list size:"+outlist.size());
			return outlist;

		}
	
	
	
}
