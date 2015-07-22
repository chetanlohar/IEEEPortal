package com.ieeeportal.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.dao.impl.StudentEnquiryDAOImpl;
import com.ieeeportal.entity.CityEntity;
import com.ieeeportal.entity.CollegeEntity;
import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.ReferenceEntity;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;
import com.ieeeportal.service.StudentEnquiryService;
import com.ieeeportal.util.StudentOperation;

public class StudentEnquiryServiceImpl implements StudentEnquiryService {

	
	StudentEnquiryDAOImpl studentEnquiryDAO = null;
	StudentOperation studentOperation = null;
	public StudentEnquiryServiceImpl(){
		studentEnquiryDAO = new StudentEnquiryDAOImpl();
		studentOperation = new StudentOperation();
	}
	
	
	
	public String studentEnquiryDetails(StudentEntity enquiryEntity) {
		StudentEnquiryDAOImpl studentEnquiryDAO=new StudentEnquiryDAOImpl();
		return studentEnquiryDAO.insertEnquiryRecord(enquiryEntity);
		
	}

	public List<CityEntity> cityList() {
		
		StudentEnquiryDAOImpl studentEnquiryDAO=new StudentEnquiryDAOImpl();
		/*List<CityEntity> cities = new ArrayList<CityEntity>();*/
		
		List<CityEntity> cities = studentEnquiryDAO.citiesList();
				
		return cities;
	}

	public List<DomainEntity> domainList() {
		StudentEnquiryDAOImpl studentEnquiryDAO=new StudentEnquiryDAOImpl();
		/*List<DomainEntity> domains = new ArrayList<DomainEntity>();*/
		
		List<DomainEntity> domains = studentEnquiryDAO.domainList();
		return domains;
	}

	public List<CollegeEntity> collegeList() {
		StudentEnquiryDAOImpl studentEnquiryDAO=new StudentEnquiryDAOImpl();
		/*List<CollegeEntity> collegeList = new ArrayList<CollegeEntity>();*/
		
		List<CollegeEntity> collegeList =  studentEnquiryDAO.collegeList();
		
		return collegeList;
	}

	public List<ReferenceEntity> referenceList() {
	
		StudentEnquiryDAOImpl studentEnquiryDAO=new StudentEnquiryDAOImpl();
		/*List<ReferenceEntity> referenceList =new ArrayList<ReferenceEntity>();*/
		
		List<ReferenceEntity> referenceList = studentEnquiryDAO.referenceList();

		return referenceList;
	}

	@Override
	public List<StudentDetailsEntity> enquiredStudentList() {
		List<StudentDetailsEntity> enquiredStudentList = studentEnquiryDAO.enquiredStudentList();
		return enquiredStudentList;
	}
	 
	public List<StudentDetailsEntity> enquiredSpStudentList(String name){
		List<StudentDetailsEntity> enquiredSpStudentList = studentOperation.getSpEnquiredStudentList(name);
		return enquiredSpStudentList;
	}

	
	

	
	

}
