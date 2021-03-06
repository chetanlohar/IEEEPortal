package com.ieeeportal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ieeeportal.dao.EmployeeDAO;
import com.ieeeportal.entity.EmployeeEntity;
import com.ieeeportal.util.ConnectionFactory;

public class EmployeeDaoImpl implements EmployeeDAO {

	List<String> list;
	EmployeeDaoImpl employeeDaoImpl;
	static Connection connection = null;
	public EmployeeDaoImpl() {

		this.list = new ArrayList<String>();
		connection = ConnectionFactory.getConnection();
	}

	// Insert All THe Record Of Employee
	@SuppressWarnings({ "static-access", "unchecked" })
	public boolean insertEmpRecords(EmployeeEntity employee) {
		boolean flag = false;
		
		PreparedStatement statement = null;
		int empManagerId = 0, userId = 0, contactId = 0, a = 0, empId = 0;
		String reportingManagerName = null;
		
		if (connection != null) {
			// if both records insert success then(Pratik)
			if (EmployeeDaoImpl.insertEmpIntoLoginMST(employee) == true
					&& EmployeeDaoImpl.insertIntoContactMST(employee) == true) {

				try {

					employeeDaoImpl = new EmployeeDaoImpl();
					list = employeeDaoImpl.readEmpRecords(employee);
					userId = Integer.parseInt(list.get(0));
					contactId = Integer.parseInt(list.get(1));

					if (employee.getEmpdesignation() == "MD") {
						empManagerId = 0;
					} else {
						reportingManagerName = employee.getReportingManager();
						empManagerId = employeeDaoImpl
								.retriveEmpId(reportingManagerName);
						System.out
								.println("Employee manager id" + empManagerId);
					}
					String query = "insert into tbl_empdet(CLM_EMPNM,CLM_DESG,CLM_DOJ,CLM_GENDER,CLM_USRID,CLM_MGRID,CLM_EMPADD) values(?,?,?,?,?,?,?)";

					statement = connection.prepareStatement(query);
					statement.setString(1, employee.getEmpName());
					statement.setString(2, employee.getEmpdesignation());
					statement.setString(3, employee.getEmpDateOfJoinning());
					statement.setString(4, employee.getEmpGender());
					statement.setInt(5, userId);
					statement.setInt(6, empManagerId);
					statement.setString(7, employee.getEmpAddress());
					a = statement.executeUpdate();

					if (a == 1) {
						// insert into pure details of empcontdet
						empId = employeeDaoImpl.retriveEmpId(employee
								.getEmpName());
						System.out.println("EmpContDet contid " + contactId
								+ " emp id " + empId);
						EmployeeDaoImpl.insertEmpContDet(contactId, empId);
						flag = true;
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					try {
						statement.close();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		}// insert method if close
		return flag;
	}

	// this method insert Employee Email_Id and Password into loginMST(Pratik)
	public static boolean insertEmpIntoLoginMST(EmployeeEntity employee) {

		String encryptedPassword = null;
		try {
			encryptedPassword = EncryptPassword.encrypt(employee
					.getEmpPassword());
			System.out.println("encrypted pass=" + encryptedPassword);

			String decryptedPassword = EncryptPassword
					.decrypt(encryptedPassword);
			System.out.println("decrypted pass=" + decryptedPassword);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		PreparedStatement statement = null;
		boolean flag = false;
		int a = 0;
		
		if (connection != null) {
			String query = "insert into tbl_loginmst(CLM_EMLID,CLM_USRPASS,CLM_USRROLE) values(?,?,?)";
			try {
				statement = connection.prepareStatement(query);
				statement.setString(1, employee.getEmpEmailID());
				statement.setString(2, encryptedPassword);
				statement.setString(3, employee.getEmpRole());
				a = statement.executeUpdate();
				System.out
						.println("Records Insert Into login Master successfully"
								+ a);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (a == 1) {
				flag = true;
			}
		}
		return flag;
	}

	// this method insert record into contact master(Pratik)
	public static boolean insertIntoContactMST(EmployeeEntity employee) {

		
		PreparedStatement statement = null;
		boolean flag = false;
		int a = 0;
		
		if (connection != null) {
			String query = "insert into tbl_contmst(CLM_PHNO,CLM_EMLID) values(?,?)";
			try {
				statement = connection.prepareStatement(query);
				statement.setString(1, employee.getEmpContactNo());
				statement.setString(2, employee.getEmpEmailID());
				a = statement.executeUpdate();
				System.out
						.println("Records Insert Into Contact Master successfully"
								+ a);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				try {
					statement.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (a == 1) {
				flag = true;
			}
		}
		return flag;
	}

	// retrive all employee records
	public List readEmpRecords(EmployeeEntity employee) {
		String contactId = null;
		String userId = null;
		// contactid from loginmst which is fk in empdet
		contactId = EmployeeDaoImpl.readContactId(employee);
		// userid from loginmst which is fk in empdet
		userId = EmployeeDaoImpl.readUserId(employee);
		System.out.println("Employee UserId" + userId);
		list.add(userId);
		list.add(contactId);
		return list;
	}

	public static String readContactId(EmployeeEntity employee) {

		System.out.println(" Heloo in method call");
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String contactId = null;
		if (connection != null) {
			try {
				String query = "select CLM_CONTID FROM tbl_contmst where CLM_EMLID=?";
				statement = connection.prepareStatement(query);
				statement.setString(1, employee.getEmpEmailID());
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					contactId = resultSet.getString(1);
				}

			} catch (SQLException e) {

				e.printStackTrace();

			} finally {

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

	public static String readUserId(EmployeeEntity employee) {
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String userId = null;
		if (connection != null) {
			try {
				String query = "select CLM_USRID FROM tbl_loginmst where CLM_EMLID=?";
				statement = connection.prepareStatement(query);
				statement.setString(1, employee.getEmpEmailID());
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					userId = resultSet.getString(1);
				}

			} catch (SQLException e) {

				e.printStackTrace();

			} finally {

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

	
	public List getEmployeeRecords() {// get all employee records

		List<EmployeeEntity> list = new ArrayList<EmployeeEntity>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				String query = "select * FROM tbl_empdet";// change on 17-7-2015
				statement = connection.prepareStatement(query);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					EmployeeEntity employeeEntity = new EmployeeEntity();
					employeeEntity.setEmpName(resultSet.getString("CLM_EMPNM"));
					employeeEntity.setEmpdesignation(resultSet
							.getString("CLM_DESG"));// change on 17-7-2015
					employeeEntity.setEmpID(Integer.parseInt(resultSet
							.getString("CLM_EMPID")));
					employeeEntity.setEmpDateOfJoinning(resultSet
							.getString("CLM_DOJ"));
					employeeEntity.setEmpGender(resultSet
							.getString("CLM_GENDER"));
					employeeEntity.setEmpAddress(resultSet
							.getString("CLM_EMPADD"));
					list.add(employeeEntity);
				}

			} catch (SQLException e) {

				e.printStackTrace();

			} finally {

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

	public static int retriveEmpId(String empName) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int empid = 0;
		if (connection != null) {
			System.out.println("connection object" + connection);
			String query = "select CLM_EMPID from tbl_empdet where CLM_EMPNM=?";
			try {
				statement = connection.prepareStatement(query);
				statement.setString(1, empName);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					empid = resultSet.getInt("CLM_EMPID");
					System.out.println("  emp id in while of RetriveEmpId"
							+ empid);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(" team leader emp id" + empid);
		return empid;

	}

	public static String retriveEmpName(int empId) {

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String empName = null;
		if (connection != null) {
			System.out.println("connection object" + connection);
			String query = "select * from tbl_empdet where CLM_EMPID=?";
			try {
				statement = connection.prepareStatement(query);
				statement.setInt(1, empId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					empName = resultSet.getString("CLM_EMPNM");
					System.out
							.println(" emp Name in retriveEmpName " + empName);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return empName;

	}

	public static void insertEmpContDet(int contactId, int empId) {
		System.out.println(" in insert method of insertEmpContDet ");
		PreparedStatement preparedStatement = null;
		if (connection != null) {
			String query = "insert into tbl_empcontdet(CLM_CONTID,CLM_EMPID) values(?,?)";
			try {
				preparedStatement = connection.prepareStatement(query);
				System.out
						.println("In insert method of insertEmpContDet contid "
								+ contactId + " emp id " + empId);
				preparedStatement.setInt(1, contactId);
				preparedStatement.setInt(2, empId);
				preparedStatement.executeUpdate();
				System.out.println("Inserted   empcontactdet Sucess fully...");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public String getEmployeeName(EmployeeEntity employeeEntity) {
		String employeeName=null;
		int userId=0;
		ResultSet resultSet=null;
		 
		PreparedStatement preparedStatement=null;
		if(connection!=null){
			
			userId=(Integer.parseInt(EmployeeDaoImpl.readUserId(employeeEntity)));
			String query="select * from tbl_empdet where CLM_USRID=?";
			try{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1,userId);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				
				employeeName=resultSet.getString("CLM_EMPNM");
			}
			
			}catch(SQLException sqe){
				
				System.out.println(" Error in getEmployeeName "+sqe.getMessage());
			}
		}
		
		return employeeName;
	}

}
