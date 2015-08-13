package com.ieeeportal.dao.impl;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.ieeeportal.dao.StudentEnquiryDAO;
import com.ieeeportal.entity.CityEntity;
import com.ieeeportal.entity.CollegeEntity;
import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.ReferenceEntity;
import com.ieeeportal.entity.StudentDetailsEntity;
import com.ieeeportal.entity.StudentEntity;
import com.ieeeportal.service.impl.StudentEnquiryServiceImpl;
import com.ieeeportal.util.ConnectionFactory;

public class StudentEnquiryDAOImpl implements StudentEnquiryDAO {

	// for inserting student enquiry records into database
	Connection connection = null;
    public StudentEnquiryDAOImpl(){
    	connection = ConnectionFactory.getConnection();
    }
	public String insertEnquiryRecord(StudentEntity enquiryEntity) {
		// TODO Auto-generated method stub

		System.out.println(" hi from insertEnquiryRecord()");

		
		

		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		PreparedStatement preparedStatement4 = null;
		PreparedStatement preparedStatement5 = null;
		PreparedStatement preparedStatement6 = null;
		PreparedStatement preparedStatement7 = null;
		PreparedStatement preparedStatement8 = null;
		PreparedStatement preparedStatement9 = null;
		PreparedStatement preparedStatement11=null;
		PreparedStatement preparedStatement12=null;
		PreparedStatement preparedStatement13=null;

		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		ResultSet resultSet7=null;
		ResultSet resultset8=null;

		int collegeId = 0;
		int domainId = 0;
		int cityId = 0;
		int referenceId = 0;
		int enquiryId = 0;
		int contID = 0;
    	String enqid=null;
        int[] domId=new int[10];

		// /String query =
		// "INSERT INTO tbl_enqdet(CLM_ENQDATE,CLM_TECH,CLM_TEAMSZ,CLM_DEPT) VALUES(?,?,?,?)";

		int status1 = 0, status2 = 0, status3 = 0,status4=0;

		String query1 = "INSERT INTO tbl_contmst(CLM_PHNO,CLM_EMLID)values(?,?)";
		String query6 = "INSERT INTO tbl_enqdet (CLM_ENQDATE,CLM_TECH,CLM_REFID,CLM_TEAMSZ,CLM_DEPT,CLM_CLGID,CLM_DOMID,CLM_CITYID) VALUES(?,?,?,?,?,?,?,?)";
		String query7 = "SELECT CLM_CONTID from tbl_contmst ORDER BY CLM_CONTID DESC LIMIT 1";
		String query8 = "SELECT clm_enqid FROM tbl_enqdet ORDER BY clm_enqid DESC LIMIT 1";
		String query9 = "INSERT INTO tbl_enqcontdet(CLM_ENQNM,CLM_GENDER,CLM_ENQID) VALUES(?,?,?)";
		String query10 = "INSERT INTO tbl_enqcontdet(CLM_CONTID,CLM_ENQNM,CLM_GENDER,CLM_ENQID) VALUES(?,?,?,?)";
		String query11="SELECT clm_enqid FROM tbl_enqdet ORDER BY clm_enqid DESC LIMIT 1";
		String query12="INSERT INTO  tbl_pprenqcnt(clm_enqid,clm_projid,clm_projdomid) VALUES(?,?,?)";
		String query13="SELECT clm_domid FROM tbl_projdet WHERE clm_projid=?;";
		List<Integer> listOfContId = new ArrayList<Integer>();

		String[] contA = Arrays.copyOf(enquiryEntity.getStudentContactList()
				.toArray(),
				enquiryEntity.getStudentContactList().toArray().length,
				String[].class);
		

		String[] emailA = Arrays.copyOf(enquiryEntity.getStudentEmailList()
				.toArray(),
				enquiryEntity.getStudentEmailList().toArray().length,
				String[].class);

		String[] nameA = Arrays.copyOf(enquiryEntity.getStudentNameList()
				.toArray(),
				enquiryEntity.getStudentNameList().toArray().length,
				String[].class);

		String[] genderA = Arrays.copyOf(enquiryEntity.getStudentGenderList()
				.toArray(),
				enquiryEntity.getStudentGenderList().toArray().length,
				String[].class);
		
		String[] paperA = Arrays.copyOf(enquiryEntity.getStudentpaperList()
				.toArray(),
				enquiryEntity.getStudentpaperList().toArray().length,
				String[].class);



		Integer[] contIdA = (Integer[]) listOfContId
				.toArray(new Integer[listOfContId.size()]);

		try {
				preparedStatement6 = connection.prepareStatement(query6);

			preparedStatement6.setString(1, enquiryEntity.getEnquiryDate());
			preparedStatement6.setString(2,
					enquiryEntity.getStudentTechnology());
			preparedStatement6.setInt(3, enquiryEntity.getStudentReferenceId());
			preparedStatement6.setInt(4, enquiryEntity.getStudentTeamsize());
			preparedStatement6.setString(5,
					enquiryEntity.getStudentDepartment());
			preparedStatement6.setInt(6, enquiryEntity.getStudentCollegeId());
			preparedStatement6.setInt(7, enquiryEntity.getStudentDomainId());
			preparedStatement6.setInt(8, enquiryEntity.getStudentCityId());

			status2 = preparedStatement6.executeUpdate();

			if (status2 > 0) {
				preparedStatement1 = connection.prepareStatement(query1);

				for (int i = 0; i < contA.length; i++) {

					preparedStatement1.setString(1, contA[i]);
					preparedStatement1.setString(2, emailA[i]);
					status1 = preparedStatement1.executeUpdate();
					if (status1 > 0) {
						preparedStatement7 = connection
								.prepareStatement(query7);
						resultSet5 = preparedStatement7.executeQuery();
						while (resultSet5.next()) {
							contID = resultSet5.getInt(1);

						}
						preparedStatement8 = connection
								.prepareStatement(query8);

						resultSet6 = preparedStatement8.executeQuery();
						while (resultSet6.next()) {
							enquiryId = resultSet6.getInt(1);
						}
						PreparedStatement preparedStatement10 = connection
								.prepareStatement(query10);
						preparedStatement10.setInt(1, contID);
						preparedStatement10.setString(2, nameA[i]);
						preparedStatement10.setString(3, genderA[i]);
						preparedStatement10.setInt(4, enquiryId);
						status3 = preparedStatement10.executeUpdate();
					}

				}
			}
			if (status2 > 0) {

				System.out.println("records inserted into enqDet");

			}
			if (status3 > 0) {
				System.out.println("records inserted into enqDet");
	             preparedStatement11=connection.prepareStatement(query11);			
				resultSet7=preparedStatement11.executeQuery();
				while(resultSet7.next()){
					
					System.out.println(" Last EnqId"+resultSet7.getString("clm_enqid"));
				      enqid=resultSet7.getString("clm_enqid");
				}
                
				preparedStatement13=connection.prepareStatement(query13);
				for(int i=0;i<paperA.length;i++){
					preparedStatement13.setInt(1, Integer.parseInt(paperA[i]));
				    resultset8=preparedStatement13.executeQuery();
				    while(resultset8.next()){
				    	domId[i]=resultset8.getInt("clm_domid");
				    }
				    System.out.println(" domainsid"+domId.toString());
				}
				System.out.println("Resultset i.e domain id of difeent papers"+resultset8.toString());
				
				preparedStatement12=connection.prepareStatement(query12);
				for(int i=0;i<paperA.length;i++){
				preparedStatement12.setInt(1,(Integer.parseInt(enqid)));	
				preparedStatement12.setInt(2, Integer.parseInt(paperA[i]));
				preparedStatement12.setInt(3, domId[i]);
				
				status4=preparedStatement12.executeUpdate();
				}
				if(status4>0){
					System.out.println("records inserted into tbl_pprenqcnt");
				}
			}

		} catch (Exception sqe) {
			System.out.println("In StudentEnquiryDAOimpl in insertRecord:"+ sqe.getMessage());
		}
		return "inserted";

	}

	
	//List Of Cities will be return in arraylist
	
	public List<CityEntity> citiesList() {
		
		System.out.println("Hii from citiesList() in DAOIMPL");
		
		List<CityEntity> citylist = new ArrayList<CityEntity>();
		
		
		
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		String query = "SELECT * FROM tbl_citymst";
		
		try {
		
			preparedStatement = connection.prepareStatement(query);
			resultset = preparedStatement.executeQuery();
			
			while(resultset.next()){
				
				CityEntity cities = new CityEntity();
				cities.setCityId(resultset.getInt("CLM_CITYID"));
				cities.setCityName(resultset.getString("CLM_CITYNM"));
				
				citylist.add(cities);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return citylist;
	}

	
	//List Of Domains will be return in arraylist
	
	public List<DomainEntity> domainList() {
		
		System.out.println("Hii from DomainLIst() from DAO");
		
		
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		
		
		List<DomainEntity> domainlist = new ArrayList<DomainEntity>();
 		
		
		
		String query = "SELECT * FROM tbl_dommst";
		
		
		try {
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
		
		while(resultset.next()){
			
			DomainEntity domains =  new DomainEntity();
			
			domains.setDomainId(resultset.getInt("CLM_DOMID"));
			domains.setDomainName(resultset.getString("clm_DOMNM"));
			
			
			domainlist.add(domains);
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return domainlist;
	}

	

	//List Of College will be return in arraylist
	
	public List<CollegeEntity> collegeList() {
		
		
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;
		
		List<CollegeEntity> colleges = new ArrayList<CollegeEntity>();
				
		
		
		String query = "SELECT * FROM tbl_clgmst";
		try {
			
			preparedstatement = connection.prepareStatement(query);
			
		resultset = preparedstatement.executeQuery();
		
		while(resultset.next()){

			CollegeEntity collegeEntity = new CollegeEntity();
			
			collegeEntity.setCollegeId(resultset.getInt("CLM_CLGID"));
			collegeEntity.setCollegeName(resultset.getString("CLM_CLGNM"));
			
			colleges.add(collegeEntity);
			
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return colleges;
	}


	public List<ReferenceEntity> referenceList() {
		
		
		
		PreparedStatement preparedstatement = null;
		
		ResultSet resultset = null;
		List<ReferenceEntity> references = new ArrayList<ReferenceEntity>();

		String query = "SELECT * FROM tbl_refmst";
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			resultset = preparedstatement.executeQuery();
			
			
			while(resultset.next()){
				
				ReferenceEntity referenceEntity = new ReferenceEntity();
				
				referenceEntity.setReferenceId(resultset.getInt("CLM_REFID"));
				referenceEntity.setReferenceName(resultset.getString("CLM_REFNM"));
				
				references.add(referenceEntity);
				
			}
			
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return references;
	}
	
	
	
	@Override
	public List<StudentDetailsEntity> enquiredStudentList() {
		List<StudentDetailsEntity> listOfEnqStudents = new ArrayList<StudentDetailsEntity>();
		String query = "SELECT ed.CLM_ENQID,ed.CLM_ENQDATE,ecd.CLM_ENQNM,cntm.CLM_PHNO,"+
				"cntm.CLM_EMLID,cm.CLM_CLGNM FROM tbl_clgmst cm"+" LEFT OUTER JOIN tbl_enqdet ed "+
				"ON ed.CLM_CLGID=cm.CLM_CLGID RIGHT OUTER JOIN tbl_enqcontdet ecd ON "+
				"ed.CLM_ENQID=ecd.CLM_ENQID RIGHT OUTER JOIN  tbl_contmst cntm ON "+
				"cntm.CLM_CONTID=ecd.CLM_CONTID WHERE ed.CLM_STATUS=?"+
				"ORDER BY ed.CLM_ENQID";
		try{
		    PreparedStatement preparedStatement = connection.prepareStatement(query);
		    preparedStatement.setString(1, "Enquired");
		    ResultSet rs = preparedStatement.executeQuery();
		    while(rs.next()){
		    	StudentDetailsEntity sdEntity = new StudentDetailsEntity();
		    	sdEntity.setEnqid(rs.getInt(1));
		    	sdEntity.setEnqdate(rs.getString(2));
		    	sdEntity.setStdname(rs.getString(3));
		    	sdEntity.setPhoneno(rs.getString(4));
		    	sdEntity.setEmailid(rs.getString(5));
		    	sdEntity.setClgname(rs.getString(6));
		    	listOfEnqStudents.add(sdEntity);
		    }
		   
		}catch(SQLException sqe){
			System.out.println("In StudentEnquiryDAOImpl in enquiredStudentList "+sqe.getMessage());
		}
		 return listOfEnqStudents;
	}
	@Override
	public List<String> getPaperPathFromId(StudentEntity studEntity) {
		List<String> listOfPaperPath = new ArrayList<String>();
		String query = "SELECT clm_projppr FROM tbl_projdet WHERE clm_projid = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			for(String paerlist:studEntity.getStudentpaperList()){
				preparedStatement.setString(1,paerlist);
				ResultSet rsofPP = preparedStatement.executeQuery();
				while(rsofPP.next())
					listOfPaperPath.add(rsofPP.getString(1));
			}
		}catch(SQLException sqe){
			System.out.println("In StudentEnquiryDAOImpl in getPaperPathFromId:"+sqe.getMessage());
		}
		return listOfPaperPath;
	}
	
	
	
	
	
	
	

}
