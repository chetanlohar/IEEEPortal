package com.ieeeportal.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ieeeportal.dao.ProjectListDAO;
import com.ieeeportal.entity.ProjectDetailEntity;
import com.ieeeportal.util.ConnectionFactory;

public class ProjectListDAOImpl implements ProjectListDAO {
	Connection con;
	ResultSet rs;
	ArrayList<ProjectDetailEntity> prjlist = new ArrayList<ProjectDetailEntity>();
	ProjectDetailEntity detailEntity;

	public ArrayList<ProjectDetailEntity> getProjectList() {

		System.out.println("hi");
		try {
			con = ConnectionFactory.getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT p.CLM_PROJID, p.CLM_PROJSTAT,p.CLM_PROJPPRYEAR,p.CLM_PROJTLE,p.CLM_PROJPPR,pt.CLM_PROJTYPENM,dm.CLM_DOMNM FROM tbl_projtypemst pt,tbl_dommst dm,tbl_projdet p WHERE p.CLM_PROJTYPEID=pt.CLM_PROJTYPEID AND p.CLM_DOMID=dm.CLM_DOMID");
			int i = 0, val = 0;
			if (rs != null) {
				val = 1;
			}
			System.out.println("hi2");

System.out.println("val:"+val);
			while (rs.next()) {

				detailEntity = new ProjectDetailEntity();
				detailEntity.setPrjdom(rs.getString("CLM_DOMNM"));
				detailEntity.setPrjid(rs.getInt("CLM_PROJID"));
				detailEntity.setPrjpath(rs.getString("CLM_PROJPPR"));
				detailEntity.setPrjsta(rs.getString("CLM_PROJSTAT"));
				detailEntity.setPrjtitle(rs.getString("CLM_PROJTLE"));
				detailEntity.setPrjyear(rs.getString("CLM_PROJPPRYEAR"));
				detailEntity.setPrjtype(rs.getString("CLM_PROJTYPENM"));
				prjlist.add(detailEntity);
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
		return prjlist;
	}

}
