package com.ieeeportal.dao;

public interface UpdateStudentPaymentDAO {
	public boolean updateStudpayment(String grpid,String empdid,String amt);
public String getLastpaid(String grpid);

}
