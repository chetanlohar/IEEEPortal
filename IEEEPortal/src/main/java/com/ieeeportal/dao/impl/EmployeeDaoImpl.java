package com.ieeeportal.dao.impl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.dao.EmployeeDAO;
import com.ieeeportal.entity.EmployeeEntity;
import com.ieeeportal.util.ConnectionFactory;


public class EmployeeDaoImpl implements EmployeeDAO{

	List<String> list; 
	EmployeeDaoImpl employeeDaoImpl;
	public EmployeeDaoImpl() {
	
	  this.list=new ArrayList<String>();
	}
	//Insert All THe Record Of Employee
	public void insertEmpRecords(EmployeeEntity employee) {
		Connection connection=null;
		PreparedStatement statement=null;
		int empManagerId=0,userId=0,contactId=0,a=0,empId=0;
		String reportingManagerName=null; 
		connection=ConnectionFactory.getConnection();
      if(connection!=null) 
      {
    	  //if both records insert success then(Pratik)
    	  if(EmployeeDaoImpl.insertEmpIntoLoginMST(employee)==true 
    		 && EmployeeDaoImpl.insertIntoContactMST(employee)==true)
    	  {
   
      try { 
   	   
    	   employeeDaoImpl=new EmployeeDaoImpl();
    	   list=employeeDaoImpl.readEmpRecords(employee);
    	   userId=Integer.parseInt(list.get(0));
    	   contactId=Integer.parseInt(list.get(1));
    	   
    	   if(employee.getEmpdesignation()=="MD")
    	   {
    		   empManagerId=0;
    	   }
    	   else{
    		   reportingManagerName=employee.getReportingManager();
    		   empManagerId=employeeDaoImpl.retriveEmpId(reportingManagerName);
    	       System.out.println("Employee manager id"+empManagerId);   	  
    	       }       	  
    	  String query="insert into tbl_empdet(CLM_EMPNM,CLM_DESG,CLM_DOJ,CLM_GENDER,CLM_USRID,CLM_MGRID,CLM_EMPADD) values(?,?,?,?,?,?,?)";
	    
			statement=connection.prepareStatement(query);
			statement.setString(1, employee.getEmpName());
			statement.setString(2, employee.getEmpdesignation());
			statement.setString(3, employee.getEmpDateOfJoinning());
			statement.setString(4, employee.getEmpGender());
			statement.setInt(5,userId);
			statement.setInt(6,empManagerId);
			statement.setString(7, employee.getEmpAddress());
			a=statement.executeUpdate();
			
			if(a==1){
				//insert into pure details of empcontdet 
				       empId=employeeDaoImpl.retriveEmpId(employee.getEmpName());
				       System.out.println("EmpContDet contid "+contactId+" emp id "+empId);
				       EmployeeDaoImpl.insertEmpContDet(contactId,empId);
		        	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				statement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}                 	      
		
	  }

      }// insert method if close 
    }
	//this method insert Employee Email_Id and Password into loginMST(Pratik) 	
public static boolean insertEmpIntoLoginMST(EmployeeEntity employee) {
		
	String encryptedPassword=null;
	try {
		encryptedPassword = EncryptPassword.encrypt(employee.getEmpPassword());
		System.out.println("encrypted pass="+encryptedPassword);
		
		String decryptedPassword = EncryptPassword.decrypt(encryptedPassword);    
        System.out.println("decrypted pass="+decryptedPassword);
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    
	      
		Connection connection=null;
		PreparedStatement statement=null;
		boolean flag=false;
		int a=0;
		connection=ConnectionFactory.getConnection();
		if(connection!=null){
		String query="insert into tbl_loginmst(CLM_EMLID,CLM_USRPASS,CLM_USRROLE) values(?,?,?)";
		try{
		statement=connection.prepareStatement(query);
		statement.setString(1,employee.getEmpEmailID());
		statement.setString(2,encryptedPassword);
		statement.setString(3,employee.getEmpRole());
		a=statement.executeUpdate();
		System.out.println("Records Insert Into login Master successfully"+a);
		}catch(SQLException e){
		e.printStackTrace();
		}
		finally{
			
			try {
				statement.close();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(a==1){
			flag=true; 
		}
	}
    	return flag;
	} 
	
	//this method insert record into contact master(Pratik) 
	public static boolean insertIntoContactMST(EmployeeEntity employee){
  
		Connection connection=null;
		PreparedStatement statement=null;
		boolean flag=false;
		int a=0;
		connection=ConnectionFactory.getConnection();
		if(connection!=null){
		String query="insert into tbl_contmst(CLM_PHNO,CLM_EMLID) values(?,?)";
		try{
		statement=connection.prepareStatement(query);
		statement.setString(1,employee.getEmpContactNo());
		statement.setString(2,employee.getEmpEmailID());
		a=statement.executeUpdate();
		System.out.println("Records Insert Into Contact Master successfully"+a);
		}catch(SQLException e){
		e.printStackTrace();
		}finally{
			
			try {
				statement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(a==1){
			flag=true; 
		}
		}
		return flag;
	}
	
	
	//retrive all employee records 
	public  List readEmpRecords(EmployeeEntity employee) {
		String contactId=null;
		String userId=null;
		//contactid from loginmst which is fk in empdet
  	  contactId=EmployeeDaoImpl.readContactId(employee);
  	  //userid from loginmst which is fk in empdet 
  	  userId=EmployeeDaoImpl.readUserId(employee);
  	  System.out.println("Employee UserId"+userId);
  	  list.add(userId);
  	  list.add(contactId);
  	  return list; 
	}
public static String readContactId(EmployeeEntity employee){
		
		System.out.println(" Heloo in method call");
		Connection connection=null;
		PreparedStatement statement=null;
		connection=ConnectionFactory.getConnection();
		ResultSet resultSet=null;
		String contactId=null;
		if(connection!=null){
		try{	
		  String query="select CLM_CONTID FROM tbl_contmst where CLM_EMLID=?";
  		  statement=connection.prepareStatement(query);
  		  statement.setString(1,employee.getEmpEmailID());
  		  resultSet=statement.executeQuery();
  		  while(resultSet.next()){
  			  contactId=resultSet.getString(1);
  		  }
			
			
		}catch(SQLException e){
			
			e.printStackTrace();
		
		}finally{
			
			try {
				statement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
		return contactId;
	}
	
	public static String readUserId(EmployeeEntity employee){
		Connection connection=null;
		PreparedStatement statement=null;
		connection=ConnectionFactory.getConnection();
		ResultSet resultSet=null;
		String userId=null;
		if(connection!=null){
		try{	
		  String query="select CLM_USRID FROM tbl_loginmst where CLM_EMLID=?";
  		  statement=connection.prepareStatement(query);
  		  statement.setString(1,employee.getEmpEmailID());
  		  resultSet=statement.executeQuery();
  		  while(resultSet.next()){
  			  userId=resultSet.getString(1);
  		  }
			
			
		}catch(SQLException e){
			
			e.printStackTrace();
		
		}finally{
			
			try {
				statement.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
		return userId;
	} 
	
	public static List getEmployeeNames(){
		
		List<EmployeeEntity> list=new ArrayList<EmployeeEntity>(); 
		Connection connection=null;
		PreparedStatement statement=null;
		connection=ConnectionFactory.getConnection();
		ResultSet resultSet=null;
		if(connection!=null){
			try{	
			  String query="select CLM_EMPNM FROM tbl_empdet";
	  		  statement=connection.prepareStatement(query);
	  		  resultSet=statement.executeQuery();
	  		  while(resultSet.next()){
	  			EmployeeEntity employeeEntity=new EmployeeEntity();
	  			  employeeEntity.setEmpName(resultSet.getString("CLM_EMPNM"));
	  			  list.add(employeeEntity);
	  		  }
				
				
			}catch(SQLException e){
				
				e.printStackTrace();
			
			}finally{
				
				try {
					statement.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		return list;
	}
	
public static int retriveEmpId(String empName){
		
		Connection connection=null;
		PreparedStatement statement= null;
		ResultSet resultSet=null;
		int empid=0;
		connection=ConnectionFactory.getConnection();
		if(connection!=null){
		System.out.println("connection object"+connection);
		String query="select CLM_EMPID from tbl_empdet where CLM_EMPNM=?";
		try {
			statement=connection.prepareStatement(query);
			statement.setString(1,empName);
			resultSet=statement.executeQuery();
			while(resultSet.next()){
			empid=resultSet.getInt("CLM_EMPID"); 	
			System.out.println("  emp id in while of RetriveEmpId"+empid);	
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	System.out.println(" team leader emp id"+empid);	
	return empid;	
	
}
	public static void insertEmpContDet(int contactId,int empId)
	{
		System.out.println(" in insert method of insertEmpContDet ");
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		connection=ConnectionFactory.getConnection();
		if(connection!=null){
		String query="insert into tbl_empcontdet(CLM_CONTID,CLM_EMPID) values(?,?)";
		try{
		preparedStatement=connection.prepareStatement(query);
		System.out.println("In insert method of insertEmpContDet contid "+contactId+" emp id "+empId);
		preparedStatement.setInt(1,contactId);
		preparedStatement.setInt(2, empId);
		preparedStatement.executeUpdate();
		System.out.println("Inserted   empcontactdet Sucess fully...");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		}
	}
	
	
	
	
}
