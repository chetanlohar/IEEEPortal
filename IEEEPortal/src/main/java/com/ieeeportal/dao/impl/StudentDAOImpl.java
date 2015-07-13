package com.ieeeportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ieeeportal.dao.StudentDAO;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentRegistrationEntity;
import com.ieeeportal.util.ConnectionFactory;

public class StudentDAOImpl implements StudentDAO {
private Connection connection;
	
	ResultSet rs;
	double unpaidamt,totamt,paidamt;
	ArrayList<StudentDetailsEntity> stddetaillist = new ArrayList<StudentDetailsEntity>();
	StudentDetailsEntity detailEntity;
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
	@Override
	public ArrayList<StudentDetailsEntity> getAllStudentList() {
		System.out.println("hi");
		try {
			
			Statement st = connection.createStatement();
			String query="SELECT  srd.CLM_GRPID,srd.CLM_REGDATE,srd.CLM_TECH,srd.CLM_TEAMSZ,srd.CLM_DEPT,srd.CLM_STUDSTAT,srd.CLM_TOTFEE,srd.CLM_DSCAMT,"
+" sid.CLM_STUDNM ,cm.CLM_CLGNM ,psb.CLM_PROJTITLE,srd.CLM_TOTPAID FROM tbl_clgmst cm"

+" LEFT OUTER JOIN tbl_studregdet srd  ON"
+" srd.CLM_CLGID=cm.CLM_CLGID"
+" RIGHT OUTER JOIN tbl_projsubdet psb"
+" ON srd.CLM_GRPID=psb.CLM_GRPID"
+" RIGHT OUTER JOIN  tbl_studinfodet sid ON"
 +" srd.CLM_GRPID=sid.CLM_GRPID ORDER BY srd.CLM_GRPID ;";
			rs = st.executeQuery(query);
			int i = 0, val = 0;
			if (rs != null) {
				val = 1;
			}
			System.out.println("hi2");

//System.out.println("val:"+val);
			while (rs.next()) {

				detailEntity=new StudentDetailsEntity();
				detailEntity.setClgname(rs.getString("CLM_CLGNM"));
				detailEntity.setDept(rs.getString("CLM_DEPT"));
				detailEntity.setDisamt(rs.getDouble("CLM_DSCAMT"));
				detailEntity.setGrpid(rs.getInt("CLM_GRPID"));
				detailEntity.setRegdate(rs.getString("CLM_REGDATE"));
				detailEntity.setStdname(rs.getString("CLM_STUDNM"));
				detailEntity.setStstatus(rs.getString("CLM_STUDSTAT"));
				detailEntity.setTeamsize(rs.getInt("CLM_TEAMSZ"));
				detailEntity.setTech(rs.getString("CLM_TECH"));
				detailEntity.setProjname(rs.getString("CLM_PROJTITLE"));
				totamt=rs.getDouble("CLM_TOTFEE");
				paidamt=rs.getDouble("CLM_TOTPAID");
				unpaidamt=totamt-paidamt;
				detailEntity.setPaidtamt(paidamt);
				detailEntity.setTfee(totamt);
                detailEntity.setUnpaidamt(unpaidamt);
				stddetaillist.add(detailEntity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {/*
			try {
				//rs.close();
				//con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		*/}

		// TODO Auto-generated method stub
		return stddetaillist;}

	

}
