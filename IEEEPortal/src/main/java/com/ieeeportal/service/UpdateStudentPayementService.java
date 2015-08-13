package com.ieeeportal.service;

import javax.swing.text.StyledEditorKit.BoldAction;

public interface UpdateStudentPayementService
{
	
	public boolean updateStudpayment(String grpid,String empdid,String amt);
	public String getLstPayement(String grpid);

}
