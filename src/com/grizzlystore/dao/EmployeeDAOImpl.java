package com.grizzlystore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.grizzlystore.bean.Profile;
import com.grizzlystore.util.DBUtils;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection connection;
	@Override
	public int registerUser(Profile employee) {
		PreparedStatement preparedStatement = null;
		int status=0;
		connection  = DBUtils.getConnection();
		//int res=0;
		String insertStatement ="insert into login" + "(userid, password, usertype, userstatus, contactno, address)" + " values(? , ? , ? , ? , ? , ?)";
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, employee.getUserId());
			preparedStatement.setString(1, employee.getUserId());
			preparedStatement.setString(2, employee.getPassword());
			preparedStatement.setString(3, employee.getUserType());
			preparedStatement.setInt(4, status);
			preparedStatement.setLong(5, employee.getContactNumber());
			preparedStatement.setString(6, employee.getAddress());
	

			 preparedStatement.executeUpdate();
			 
			return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return -1;
	}

}
