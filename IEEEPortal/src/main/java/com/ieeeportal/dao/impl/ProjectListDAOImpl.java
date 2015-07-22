package com.ieeeportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.dao.ProjectListDAO;
import com.ieeeportal.entity.DomainEntity;
import com.ieeeportal.entity.PaperEntity;
import com.ieeeportal.entity.ProjectDetailEntity;
import com.ieeeportal.entity.ProjectRequirementsEntity;
import com.ieeeportal.util.ConnectionFactory;

public class ProjectListDAOImpl implements ProjectListDAO {
	static Connection connection = null;
	ResultSet rs = null;
	ProjectDetailEntity detailEntity;
	PaperEntity paperEntity = null;
	List<ProjectDetailEntity> projectDetailEntitieslist;
	List<ProjectDetailEntity> listofDomainName;
	List<ProjectDetailEntity> listofAssignRecords;
	

	public ProjectListDAOImpl() {
		connection = ConnectionFactory.getConnection();
	}

	public ArrayList<ProjectDetailEntity> getProjectList(int domid) {

		System.out.println("hi");
		ArrayList<ProjectDetailEntity> listOfDomWisePaper = new ArrayList<ProjectDetailEntity>();
		String query = "SELECT p.CLM_PROJID, p.CLM_PROJSTAT,p.CLM_PROJPPRYEAR,p.CLM_PROJTLE,"
				+ "p.CLM_PROJPPR,pt.CLM_PROJTYPENM,dm.CLM_DOMNM FROM tbl_projtypemst pt,tbl_dommst dm,"
				+ "tbl_projdet p WHERE p.CLM_PROJTYPEID=pt.CLM_PROJTYPEID AND p.CLM_DOMID=dm.CLM_DOMID AND "
				+ "p.CLM_DOMID = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, domid);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				detailEntity = new ProjectDetailEntity();
				detailEntity.setPrjdom(rs.getString("CLM_DOMNM"));
				detailEntity.setPrjid(rs.getInt("CLM_PROJID"));
				detailEntity.setPrjpath(rs.getString("CLM_PROJPPR"));
				detailEntity.setPrjsta(rs.getString("CLM_PROJSTAT"));
				detailEntity.setPrjtitle(rs.getString("CLM_PROJTLE"));
				detailEntity.setPrjyear(rs.getString("CLM_PROJPPRYEAR"));
				detailEntity.setPrjtype(rs.getString("CLM_PROJTYPENM"));
				listOfDomWisePaper.add(detailEntity);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {/*
					 * try { //rs.close(); //con.close(); } catch (SQLException
					 * e) { // TODO Auto-generated catch block
					 * e.printStackTrace(); }
					 */
		}
		return listOfDomWisePaper;
	}

	@Override
	public String addRequirements(ProjectRequirementsEntity projReqEntity) {

		PreparedStatement preparedStatement = null;

		String Query = "INSERT INTO tbl_reqhistdet (clm_lstvist,clm_reqmt,clm_grpid) VALUES (?,?,?);";

		try {

			preparedStatement = connection.prepareStatement(Query);

			preparedStatement.setString(1,
					projReqEntity.getDateOfRequirements());

			preparedStatement.setString(2, projReqEntity.getRequirements());

			preparedStatement.setInt(3, projReqEntity.getGroupId());

			int status = preparedStatement.executeUpdate();

			if (status > 0) {

				System.out.println("records inserted into requirements table");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "inserted";

	}
	
	@Override
	public ArrayList<DomainEntity> getProjectDomain() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<DomainEntity> arrayList = new ArrayList<DomainEntity>();
		if (connection != null) {

			String query = "select CLM_DOMNM from tbl_dommst";
			try {
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					DomainEntity domainEntity = new DomainEntity();
					domainEntity
							.setDomainName(resultSet.getString("CLM_DOMNM"));
					arrayList.add(domainEntity);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return arrayList;
	}

	public int getDomainId(DomainEntity domainEntity) {
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int domainId = 0;
		if (connection != null) {
			String query = "select CLM_DOMID from tbl_dommst where CLM_DOMNM=?";
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, domainEntity.getDomainName());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					// DomainEntity dEntity=new DomainEntity();
					// dEntity.setDomainId(resultSet.getInt("CLM_DOMID"));
					domainId = resultSet.getInt("CLM_DOMID");
				}
			} catch (SQLException e) {
				System.out.println("Error comes in Project List Dao "
						+ e.getStackTrace());

			}
		}
		return domainId;
	}

	@Override
	public ArrayList<PaperEntity> getPapersName(DomainEntity domainEntity) {
		PreparedStatement preparedStatement = null;
		ArrayList<PaperEntity> paperList = new ArrayList<PaperEntity>();

		if (connection != null) {

			String query = "SELECT CLM_PROJTLE FROM tbl_projdet where CLM_DOMID=?";
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, domainEntity.getDomainId());
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					paperEntity = new PaperEntity();
					paperEntity.setPapertitle((resultSet
							.getString("CLM_PROJTLE")));
					paperList.add(paperEntity);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Size of Paper List" + paperList.size());
		return paperList;
	}

	public static int getprojectSubId(ProjectDetailEntity projectDetailEntity) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int projectSubtId = 0;
		if (connection != null) {
			System.out.println(" I am in getprojectSubId  and paperID  "
					+ projectDetailEntity.getPrjid());
			String query = "select * from tbl_projsubdet where CLM_PROJID=?";
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, projectDetailEntity.getPrjid());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					System.out.println(" Project Sub Id"
							+ resultSet.getInt("CLM_PROJSUBID"));
					projectSubtId = resultSet.getInt("CLM_PROJSUBID");
				}
			} catch (SQLException sqe) {

				System.out
						.println(" Errors in ProjectList Dao getprojectSubId method "
								+ sqe.getStackTrace());
			}
		}

		return projectSubtId;
	}

	@Override
	public boolean assignedProject(ProjectDetailEntity detailEntity) {
		int projectSubID = 0, recordsInsert = 0;
		boolean flag = false;
			PreparedStatement preparedStatement = null;
		if (connection != null) {
			projectSubID = ProjectListDAOImpl.getprojectSubId(detailEntity);
			System.out.println("I am in assignedProject" + projectSubID);
			if (projectSubID != 0) {
				String query = "insert into tbl_projasgndet(CLM_EMPID,CLM_PROJSUBID) values(?,?)";

				try {
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, detailEntity.getEmpId());
					preparedStatement.setInt(2, projectSubID);
					recordsInsert = preparedStatement.executeUpdate();
					System.out.println(" Records insert sucessfully..."
							+ recordsInsert);
					if (recordsInsert == 1) {
						flag = true;
					}

				} catch (SQLException sql) {

					System.out.println("Exception comes in assignedProject "
							+ sql.getStackTrace());
					sql.printStackTrace();
				}
			}

		}
		return flag;
	}

	@Override
	public List<ProjectDetailEntity> getProjectAssigned(ProjectDetailEntity detailEntity) {
	    PreparedStatement preparedStatement = null;
		int projectSubId = 0, paperId = 0, domainId = 0,empId=0;
		String paperName = null,domainName=null,empName=null;
        Timestamp dateOfAssign=null;
		ResultSet resultSet = null;
		listofAssignRecords=new ArrayList<ProjectDetailEntity>();
		
		if (connection != null) {
			String query = "SELECT * FROM tbl_projasgndet ORDER BY CLM_PROJASGNID DESC LIMIT 1";
			try {
				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				ProjectDetailEntity dEntity=new ProjectDetailEntity();
				while (resultSet.next()) {
					dateOfAssign=resultSet.getTimestamp("CLM_DOASSN");//TimeStamp Should Be Added List
					dEntity.setDateOfAssign(dateOfAssign);
					
					System.out.println(" size of listofAssignRecords : 1 "+listofAssignRecords.size());
					empId=resultSet.getInt("CLM_EMPID");//call getEmpNameMethod
					
					empName=EmployeeDaoImpl.retriveEmpName(empId);//added in list
					
					System.out.println(" EmpName in getProjectAssigned"+empName);
					
					dEntity.setEmpName(empName);//empName added to list of assign records
										
					System.out.println(" size of listofAssignRecords 2"+listofAssignRecords.size());
					System.out.println("empid " + resultSet.getInt("CLM_EMPID")
							+ " Date Of ASSN "
							+ resultSet.getTimestamp("CLM_DOASSN")
							+ "PROJSUBID " + resultSet.getInt("CLM_PROJSUBID"));
					projectSubId = resultSet.getInt("CLM_PROJSUBID");
					paperId = ProjectListDAOImpl.getPaperId(projectSubId);
					System.out.println(" paperId  in getProjectAssigned "
							+ paperId);
					projectDetailEntitieslist = ProjectListDAOImpl
							.getPaper_Domain_Name(paperId);
				}
					for (ProjectDetailEntity listpDetailEntity : projectDetailEntitieslist) {
						System.out.println(" domainId "
								+ listpDetailEntity.getDomainId()
								+ " paper Name "
								+ listpDetailEntity.getPrjtitle());
						domainId = listpDetailEntity.getDomainId();
						paperName = listpDetailEntity.getPrjtitle();//Papername Should be Added In List
						dEntity.setPrjtitle(paperName);
						
						System.out.println(" size of listofAssignRecords 3 is"+listofAssignRecords.size());
						listofDomainName=getProjectList(domainId);//call to domain name
						System.out.println("Si ze of listofDomainName"+listofDomainName.size());
						for (ProjectDetailEntity listdomainName:listofDomainName) {
							
							domainName=listdomainName.getPrjdom();//it should be added in list of assign
							dEntity.setPrjdom(domainName);
							listofAssignRecords.add(dEntity);// Domain Name Added To list of assign
							
							System.out.println("*** domainName"+domainName);
						    break;
						}
						
					}

				}

			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println(" size of listofAssignRecords-4  is:"+listofAssignRecords.size());
		return listofAssignRecords;
	}

	public static int getPaperId(int projectSubId) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int projId = 0;
		if (connection != null) {

			String query = "select CLM_PROJID from tbl_projsubdet where CLM_PROJSUBID=?";
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, projectSubId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					System.out
							.println(" Project Id From tbl_projsubdet in getPaperId of ProjectListDAOImpl"
									+ resultSet.getInt("CLM_PROJID"));
					projId = resultSet.getInt("CLM_PROJID");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return projId;
	}

	public static List<ProjectDetailEntity> getPaper_Domain_Name(int projId) {

		connection = ConnectionFactory.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<ProjectDetailEntity> projectDetailEntitylist = new ArrayList<ProjectDetailEntity>();

		if (connection != null) {

			String query = "select * from tbl_projdet where CLM_PROJID=?";
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, projId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					System.out
							.println(" Project Name From tbl_projdet in getPaperName of ProjectListDAOImpl"
									+ resultSet.getString("CLM_PROJTLE")
									+ " domain Id"
									+ resultSet.getInt("CLM_DOMID"));
					ProjectDetailEntity detailEntity = new ProjectDetailEntity();
					detailEntity
							.setPrjtitle(resultSet.getString("CLM_PROJTLE"));
					detailEntity.setDomainId(resultSet.getInt("CLM_DOMID"));
					projectDetailEntitylist.add(detailEntity);
					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return projectDetailEntitylist;
	}

	

}
