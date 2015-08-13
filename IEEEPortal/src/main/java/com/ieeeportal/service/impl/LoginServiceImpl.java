package com.ieeeportal.service.impl;

import java.util.List;

import com.ieeeportal.dao.LoginDAO;
import com.ieeeportal.dao.impl.LoginDAOImpl;
import com.ieeeportal.entity.LoginEntity;
import com.ieeeportal.service.LoginService;

public class LoginServiceImpl implements LoginService{

	LoginDAO logindao=null;

	public LoginServiceImpl() {

		logindao = new LoginDAOImpl();
	}
	
	@Override
	public String LoginCheck(LoginEntity loginEntity) {
	
		String  success = logindao.loginCheck(loginEntity);
		return success;
	}


}
