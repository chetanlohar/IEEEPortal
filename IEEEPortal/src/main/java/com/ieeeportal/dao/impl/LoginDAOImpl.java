package com.ieeeportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.dao.LoginDAO;
import com.ieeeportal.entity.CityEntity;
import com.ieeeportal.entity.LoginEntity;
import com.ieeeportal.util.ConnectionFactory;

public class LoginDAOImpl implements LoginDAO{

	private Connection connection;
	public LoginDAOImpl(){
		connection = ConnectionFactory.getConnection();
	}
	
	
	@Override
	public String loginCheck(LoginEntity loginEntity) {

		
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		
		String username = loginEntity.getLoginEmailId();
		String password = loginEntity.getLoginPassword();
		String role = loginEntity.getLoginRole();
		
		String dbusername;
		String dbPassword;
		String dbrole;
		int userId=0;
		
		boolean flag = false;
		String query = "SELECT * FROM tbl_loginmst;";
		
		try {
		
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()){
				
				
		 dbusername = (resultset.getString("CLM_EMLID"));
		 dbPassword = (resultset.getString("CLM_USRPASS"));
		 dbrole = (resultset.getString("CLM_USRROLE"));
				if(username.equalsIgnoreCase(dbusername)&&password.equalsIgnoreCase(dbPassword)&&role.equalsIgnoreCase(dbrole)){
					flag = true;
				}
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "exception";
		}
		if(flag==true){
			
			return "success";
		}
		return "failure";
	}

}
