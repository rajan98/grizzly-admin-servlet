package com.grizzlystore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.grizzlystore.bean.Vendors;
import com.grizzlystore.util.DBUtils;

public class VendorDAOImpl {
	private Connection connection;
	public Vendors getVendorById(String id)
	{
		
		PreparedStatement preparedStatement = null;
		Vendors vendor=null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String insertStatement ="select * from vendors where id = ?";
		
		try {
			
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, id);	
		    resultSet = preparedStatement.executeQuery();
			
		    if(resultSet.next())
			{
		    	vendor = new Vendors();
			 vendor.setId(resultSet.getString("id"));
			 vendor.setContactNumber(resultSet.getString("contactnumber"));
			 vendor.setAddress(resultSet.getString("address"));
			 vendor.setName(resultSet.getString("name"));
			 vendor.setRating(resultSet.getString("rating"));
			
				return vendor;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return vendor;
	}
}
