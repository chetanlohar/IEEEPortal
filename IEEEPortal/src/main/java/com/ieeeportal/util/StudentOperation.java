package com.ieeeportal.util;

import java.util.ArrayList;

import com.ieeeportal.dao.StudentDAO;
import com.ieeeportal.dao.impl.StudentDAOImpl;
import com.ieeeportal.entity.StudentDetailsEntity;

public class StudentOperation 
{
	int i=0,grpid;
	static int flag;
	StudentDetailsEntity detailsEntity=new StudentDetailsEntity();
	ArrayList<StudentDetailsEntity> studentDetailsEntities=new ArrayList<StudentDetailsEntity>();
	
	ArrayList<StudentDetailsEntity> outlist=new ArrayList<StudentDetailsEntity>();

	StudentDAO studentDAO=new StudentDAOImpl();
	public ArrayList<StudentDetailsEntity> getSpStudent(String name)
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
	
	public ArrayList<StudentDetailsEntity> getSpStudent(int mygrpid)
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

}
