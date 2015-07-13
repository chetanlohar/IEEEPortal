package com.ieeeportal.service.impl;

import java.util.List;

import com.ieeeportal.dao.LoginDAO;
import com.ieeeportal.dao.impl.LoginDAOImpl;
import com.ieeeportal.entity.LoginEntity;
import com.ieeeportal.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Override
	public String LoginCheck(LoginEntity loginEntity) {
	
		LoginDAO logindao = new LoginDAOImpl();
		
		String  success = logindao.loginCheck(loginEntity);
		
		return success;
	}
	
	

}
