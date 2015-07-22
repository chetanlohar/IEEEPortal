package com.ieeeportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ieeeportal.dao.StudentRegistrationDAO;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;
import com.ieeeportal.util.ConnectionFactory;

public class StudentRegistrationDAOImpl implements StudentRegistrationDAO {
	Connection connection = null;

	public StudentRegistrationDAOImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<StudentDetailsEntity> studenttoregList(int enqid) {
		List<StudentDetailsEntity> listOfStudents = new ArrayList<StudentDetailsEntity>();
		String query = "SELECT ctm.CLM_CITYID,ctm.CLM_CITYNM,clgm.CLM_CLGID,clgm.CLM_CLGNM,ed.CLM_DEPT,dm.CLM_DOMID,dm.CLM_DOMNM,ed.CLM_TECH,"+
				"ed.CLM_TEAMSZ,rm.CLM_REFID,rm.CLM_REFNM,ecd.CLM_ENQNM,cntm.CLM_PHNO,cntm.CLM_EMLID,ecd.CLM_GENDER "+
				"FROM tbl_citymst ctm LEFT OUTER JOIN tbl_enqdet ed ON ed.CLM_CITYID=ctm.CLM_CITYID LEFT "+
				"OUTER JOIN tbl_clgmst clgm ON ed.CLM_CLGID=clgm.CLM_CLGID LEFT OUTER JOIN tbl_dommst dm "+
				"ON ed.CLM_DOMID=dm.CLM_DOMID LEFT OUTER JOIN tbl_refmst rm ON ed.CLM_REFID=rm.CLM_REFID "+
				"RIGHT OUTER JOIN tbl_enqcontdet ecd ON ed.CLM_ENQID=ecd.CLM_ENQID RIGHT OUTER JOIN "+
				"tbl_contmst cntm ON cntm.CLM_CONTID=ecd.CLM_CONTID WHERE ed.CLM_ENQID=?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, enqid);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				StudentDetailsEntity sde = new StudentDetailsEntity();
			    sde.setCityid(rs.getInt(1));	
				sde.setCity(rs.getString(2));
				sde.setClgid(rs.getInt(3));
				sde.setClgname(rs.getString(4));
				sde.setDept(rs.getString(5));
				sde.setDomainid(rs.getInt(6));
				sde.setDomain(rs.getString(7));
				sde.setTech(rs.getString(8));
				sde.setTeamsize(rs.getInt(9));
				sde.setRefid(rs.getInt(10));
				sde.setReference(rs.getString(11));
				sde.setStdname(rs.getString(12));
				sde.setEmailid(rs.getString(13));
				sde.setPhoneno(rs.getString(14));
				sde.setGender(rs.getString(15));
				
				listOfStudents.add(sde);
			}
		}catch(SQLException sqe){
			System.out.println("In StudentRegistrationDAOImpl in studenttoregList:"+sqe.getMessage());
		}
		return listOfStudents;
	}

	@Override
	public String insertStudentRegistrationRecord(StudentEntity studententity) {
		
		String query1 = "INSERT INTO tbl_studregdet(CLM_REGDATE,CLM_TECH,CLM_TEAMSZ,CLM_DEPT,CLM_REFID,CLM_STUDSTAT,CLM_TOTFEE,CLM_DSCAMT,CLM_CLGID) VALUES(?,?,?,?,?,?,?,?,?)";
		String query2 = "INSERT INTO tbl_studinfodet(CLM_STUDNM,CLM_GENDER,CLM_GRPID) VALUES(?,?,(SELECT CLM_GRPID FROM tbl_studregdet ORDER BY CLM_GRPID DESC LIMIT 1))";
		String query3= "INSERT INTO tbl_contmst(CLM_PHNO,CLM_EMLID) SELECT * FROM (SELECT ?,?) AS tmp WHERE NOT EXISTS (SELECT CLM_PHNO,CLM_EMLID FROM tbl_contmst WHERE CLM_PHNO = ? AND CLM_EMLID=?) LIMIT 1";
		String query4 = "INSERT INTO tbl_projsubdet(CLM_PROJTITLE,CLM_PROJID,CLM_GRPID)"+ 
                         "VALUES(?,(SELECT CLM_PROJID FROM tbl_projdet WHERE CLM_PROJTLE=?),"+
                         "(SELECT CLM_GRPID FROM tbl_studregdet ORDER BY CLM_GRPID DESC LIMIT 1))";
		String query5 = "UPDATE tbl_enqdet SET CLM_STATUS = ? WHERE CLM_ENQID = ?";
	
		int q1result = 0,q2result=0,q3result=0,q4result=0,q5result=0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(query1);
			preparedStatement.setString(1, studententity.getRegDate());
			preparedStatement.setString(2, studententity.getStudentTechnology());
			preparedStatement.setInt(3, studententity.getStudentTeamsize());
			preparedStatement.setString(4, studententity.getStudentDepartment());
			preparedStatement.setInt(5, studententity.getStudentReferenceId());
			preparedStatement.setString(6, "Active");
			preparedStatement.setDouble(7, studententity.getTotalfee());
			preparedStatement.setDouble(8, studententity.getDiscount());
			preparedStatement.setInt(9, studententity.getStudentCollegeId());
			
			q1result = preparedStatement.executeUpdate();
			if(q1result > 0){
				String[] nameA = Arrays.copyOf(studententity.getStudentNameList()
						.toArray(),studententity.getStudentNameList().toArray().length,
						String[].class);

				String[] genderA = Arrays.copyOf(studententity.getStudentGenderList()
						.toArray(),studententity.getStudentGenderList().toArray().length,
						String[].class);
			    
				System.out.println("length of nameA[] is:"+nameA.length);
				
				for (int i = 0; i < nameA.length; i++) {
					PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
					preparedStatement2.setString(1, nameA[i]);
					preparedStatement2.setString(2, genderA[i]);
					
					q2result = preparedStatement2.executeUpdate();
				}
				
			}
			if(q2result > 0){
				System.out.println("I m in q2result!");
				String[] contA = Arrays.copyOf(studententity.getStudentContactList()
						.toArray(),studententity.getStudentContactList().toArray().length,
						String[].class);

				String[] emailA = Arrays.copyOf(studententity.getStudentEmailList()
						.toArray(),studententity.getStudentEmailList().toArray().length,
						String[].class);
				for (int i = 0; i < contA.length; i++) {
					PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
					preparedStatement3.setString(1, contA[i]);
					preparedStatement3.setString(2, emailA[i]);
					preparedStatement3.setString(3, contA[i]);
					preparedStatement3.setString(4, emailA[i]);
					
					q3result = preparedStatement3.executeUpdate();
				}
			   
			}
			 if(q3result >= 0){
				 System.out.println("I m in q3result ");
				PreparedStatement preparedStatement4 = connection.prepareStatement(query4);
				preparedStatement4.setString(1, studententity.getProjecttitle());
				preparedStatement4.setString(2, studententity.getProjecttitle());
				q4result = preparedStatement4.executeUpdate();
			 }
			if(q4result > 0){
				System.out.println("I m in q4result");
				PreparedStatement preparedStatement5 = connection.prepareStatement(query5);
				preparedStatement5.setString(1, "Registered");
				preparedStatement5.setInt(2, studententity.getEnquiryId());
			    q5result = preparedStatement5.executeUpdate();
				
			}
			if(q5result > 0){
				return "Success";
			}
		}catch(SQLException sqe){
			System.out.println("In StudentRegistrationDAOImpl in insertStudentRegistrationRecord"+sqe.getMessage());
		}
		return "failed";
	}

	@Override
	public int selectGrpId() {
		
		String query = "SELECT CLM_GRPID FROM tbl_studregdet ORDER BY CLM_GRPID DESC LIMIT 1";
		int grpId=0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				grpId = rs.getInt(1);
			}
		}catch(SQLException sqe){
			System.out.println("In StudentRegistrationDAOImpl in selectGrpId:"+sqe.getMessage());
		}
		return grpId;
	}
}
