package com.ieeeportal.service;

import java.util.List;

import com.ieeeportal.entity.CityEntity;
import com.ieeeportal.entity.CollegeEntity;
import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.ReferenceEntity;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;

public interface StudentEnquiryService {

	public String studentEnquiryDetails(StudentEntity enquiryEntity); 
	public List<CityEntity> cityList();
	public List<DomainEntity> domainList();
	public List<CollegeEntity> collegeList();
	public List<ReferenceEntity> referenceList();
	public List<StudentDetailsEntity> enquiredStudentList();
	public List<StudentDetailsEntity> enquiredSpStudentList(String name);
		
	
}
