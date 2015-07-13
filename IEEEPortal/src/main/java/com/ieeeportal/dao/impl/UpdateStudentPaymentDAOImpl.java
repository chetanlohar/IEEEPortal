package com.ieeeportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ieeeportal.dao.UpdateStudentPaymentDAO;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.util.ConnectionFactory;

public class UpdateStudentPaymentDAOImpl implements UpdateStudentPaymentDAO
{

	boolean res;
	Connection  connection;
	static double totalpaid,pendingamt,totfee;
	PreparedStatement preparedStatement6;
	Statement statement;
	ResultSet rs;
	StudentDetailsEntity detailsEntity=new StudentDetailsEntity();
	int status;
String query1="INSERT INTO tbl_rcptdet (CLM_GRPID,CLM_EMPID,CLM_PAID) VALUES(?,?,?);";
String query2="SELECT  CLM_TOTPAID ,CLM_TOTFEE FROM tbl_studregdet WHERE CLM_GRPID=?;";
String query3="UPDATE tbl_studregdet SET CLM_TOTPAID=? WHERE CLM_GRPID=?";


	public boolean updateStudpayment(String grpid, String empdid, String amt) {
		try {
			connection=ConnectionFactory.getConnection();
			preparedStatement6 = connection.prepareStatement(query1);

			preparedStatement6.setInt(1, Integer.parseInt(grpid));
			preparedStatement6.setInt(2,Integer.parseInt(empdid));
			preparedStatement6.setDouble(3, Double.parseDouble(amt));
			

			status=preparedStatement6.executeUpdate();
			
			if(status>0)
			{
				preparedStatement6 = connection.prepareStatement(query2);
				preparedStatement6.setInt(1, Integer.parseInt(grpid));
				rs=preparedStatement6.executeQuery();
				while(rs.next())
				{
					totalpaid=rs.getDouble(1);
					totfee=rs.getDouble(2);
				}
				if(rs!=null)
				{
					status=0;
					totalpaid=totalpaid+Double.parseDouble(amt);
					pendingamt=totfee-totalpaid;
					
					System.out.println("Grp id:"+grpid+" Total fee:"+totfee+" Totalpaid:"+totalpaid+" Pending: "+pendingamt);;
					detailsEntity.setUnpaidamt(pendingamt);
					preparedStatement6 = connection.prepareStatement(query3);
					preparedStatement6.setDouble(1, totalpaid);
					preparedStatement6.setInt(2, Integer.parseInt(grpid));
					status=preparedStatement6.executeUpdate();
					return true;
					
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		} catch (NumberFormatException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return false;
	}

}
