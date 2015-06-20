package com.ieeeportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ieeeportal.dao.StudentEnquiryDAO;
import com.ieeeportal.entity.StudentEnquiryEntity;
import com.ieeeportal.util.ConnectionFactory;

public class StudentEnquiryDAOImpl implements StudentEnquiryDAO{

	//for inserting student  enquiry records into database
	Connection connection;
	
	public void insertEnquiryRecord(StudentEnquiryEntity enquiryEntity) {
		// TODO Auto-generated method stub
		
		System.out.println(" hi from vivek..");
		
		ConnectionFactory connectionFactory = null;
		connection=connectionFactory.getConnection();
		
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		String query = "INSERT INTO tbl_enqdet(CLM_ENQDATE,CLM_TECH,CLM_TEAMSZ,CLM_DEPT,CLM_CLGID,CLM_DOMID,CLM_CITYID,CLM_REFID) VALUES(?,?,?,?,?,?,?,?)";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, enquiryEntity.getEnquiryDate());
			preparedStatement.setString(2, enquiryEntity.getStudentTechnology());
			preparedStatement.setInt(3,enquiryEntity.getStudentTeamsize());
			preparedStatement.setString(4,enquiryEntity.getStudentDepartment());
			preparedStatement.setInt(5,1);
			preparedStatement.setInt(6,2);
			preparedStatement.setInt(7,3);
			preparedStatement.setInt(8,4);
			
			
			
			int status = preparedStatement.executeUpdate();
			if(status > 0){
				System.out.println("Record inserted successfully");
			}
		}catch(Exception sqe){
			System.out.println("In StudentRegistrationDAOimpl in insertRecord:"+sqe.getMessage());
		}
		
		
	}

}
