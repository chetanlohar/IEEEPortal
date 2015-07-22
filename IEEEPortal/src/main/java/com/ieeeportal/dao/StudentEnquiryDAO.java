package com.ieeeportal.dao;

import java.util.List;

import com.ieeeportal.entity.CityEntity;
import com.ieeeportal.entity.CollegeEntity;
import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.ReferenceEntity;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;

public interface StudentEnquiryDAO {

	
	//this method takes studentenquiryentity as input
	public  String insertEnquiryRecord(StudentEntity enquiryEntity);
	public List<CityEntity> citiesList();
	public List<DomainEntity> domainList();
	public List<CollegeEntity> collegeList();
	public List<ReferenceEntity> referenceList();
	public List<StudentDetailsEntity> enquiredStudentList();
	
}
