package com.ieeeportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ieeeportal.dao.StudentDAO;
import com.ieeeportal.entity.StudentRegistrationEntity;
import com.ieeeportal.util.ConnectionFactory;

public class StudentDAOImpl implements StudentDAO {
	private Connection connection;
	public StudentDAOImpl(){
    	connection = ConnectionFactory.getConnection();
    }
	public void insertRecord(StudentRegistrationEntity studregent) {
		String query = "INSERT INTO tbl_studregdet(clm_grpid,clm_regdate,clm_tech,clm_teamsz,clm_dept,clm_studstat) VALUES(?,?,?,?,?,?)";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studregent.getGrpid());
			preparedStatement.setString(2, studregent.getRegdate());
			preparedStatement.setString(3, studregent.getTech());
			preparedStatement.setInt(4,studregent.getTeamsz());
			preparedStatement.setString(5, studregent.getDept());
			preparedStatement.setString(6, studregent.getStudstat());
			int status = preparedStatement.executeUpdate();
			if(status > 0){
				System.out.println("Record inserted successfully");
			}
		}catch(SQLException sqe){
			System.out.println("In StudentRegistrationDAOimpl in insertRecord:"+sqe.getMessage());
		}
	}

	public void updateRecord() {
		// TODO Auto-generated method stub
		
	}

	public void deleteRecord() {
		// TODO Auto-generated method stub
		
	}

	public void selectRecord() {
		// TODO Auto-generated method stub
		
	}

	

}
