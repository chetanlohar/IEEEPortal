package com.ieeeportal.service.impl;

import com.ieeeportal.dao.impl.UpdateStudentPaymentDAOImpl;
import com.ieeeportal.service.UpdateStudentPayementService;

public class UpdateStudentPaymenrServiceImpl implements UpdateStudentPayementService{
UpdateStudentPaymentDAOImpl paymentDAOImpl=new UpdateStudentPaymentDAOImpl();
boolean res;
public boolean updateStudpayment(String grpid, String empdid, String amt) 
	{
		// TODO Auto-generated method stub
		res=paymentDAOImpl.updateStudpayment(grpid, empdid, amt);
		return res;
	}
@Override
public String getLstPayement(String grpid) 
{
	// TODO Auto-generated method stub
	String lastpaid=paymentDAOImpl.getLastpaid(grpid);
	return lastpaid;
}

}
