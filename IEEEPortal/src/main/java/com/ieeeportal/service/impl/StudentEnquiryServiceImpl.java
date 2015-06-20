package com.ieeeportal.service.impl;

import com.ieeeportal.dao.impl.StudentEnquiryDAOImpl;
import com.ieeeportal.entity.StudentEnquiryEntity;
import com.ieeeportal.service.StudentEnquiryService;

public class StudentEnquiryServiceImpl implements StudentEnquiryService {

	public void studentEnquiryDetails(StudentEnquiryEntity enquiryEntity) {
		StudentEnquiryDAOImpl studentEnquiryDAO=new StudentEnquiryDAOImpl();
		studentEnquiryDAO.insertEnquiryRecord(enquiryEntity);
		
	}

	

}
