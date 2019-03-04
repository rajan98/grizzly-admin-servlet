package com.grizzlystore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.grizzlystore.bean.Profile;
import com.grizzlystore.util.DBUtils;

public class LoginDAOImpl implements LoginDAO {

	private Connection connection;
	private static LoginDAOImpl loginDAOImpl = null;
	
	public static LoginDAOImpl getInstance()
	{
		if(loginDAOImpl == null)
			loginDAOImpl = new LoginDAOImpl();
		return loginDAOImpl;
	}
	
	@Override
	public int getUserStatus(String id) {
		PreparedStatement preparedStatement = null;
		int status=0;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String insertStatement ="select userstatus from login where userid = ?";
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
	
			preparedStatement.setString(1, id);
	

			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
			 status = resultSet.getInt("userstatus");
				return status;
			}
			
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

	public String getUserType(String id,String password) {
		PreparedStatement preparedStatement = null;
		String uType="C";
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String insertStatement ="select usertype from login where userid = ?";
		
		try {
			
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, id);	
		    resultSet = preparedStatement.executeQuery();
			
		    if(resultSet.next())
			{
			 uType = resultSet.getString("usertype");
				return uType;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return uType;
	}
	
	public boolean authenticate(String userName,String password)
	{
		PreparedStatement preparedStatement = null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String insertStatement ="select * from login where userid = ? and password = ?";
		
		try {
			
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
		    resultSet = preparedStatement.executeQuery();
		    if(resultSet.next())
			{
			 return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return false;
	}
	
	@Override
	public int setUserStatus(String id)
	{
		int currentStatus = getUserStatus(id);
		currentStatus=currentStatus+1;
		PreparedStatement preparedStatement = null;
		int status=0;
		connection  = DBUtils.getConnection();
		String insertStatement ="update login set userstatus = ? where userid = ?";
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
	
			preparedStatement.setInt(1, currentStatus);
			preparedStatement.setString(2, id);
	
			status = preparedStatement.executeUpdate();
			if(status==1)
			{
				return 1;
			}
			
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
	
	public boolean authenticateUserId(String userName)
	{
		PreparedStatement preparedStatement = null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String insertStatement ="select * from login where userid = ?";
		
		try {
			
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, userName);
		    resultSet = preparedStatement.executeQuery();
		    if(resultSet.next())
			{
			 return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return false;
	}
	
	public int resetUserStatus(String id){
	
	
		PreparedStatement preparedStatement = null;
		int status=0;
		connection  = DBUtils.getConnection();
		String insertStatement ="update login set userstatus = ? where userid = ?";
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
	
			preparedStatement.setInt(1, status);
			preparedStatement.setString(2, id);
	
			status = preparedStatement.executeUpdate();
			if(status==1)
			{
				return 1;
			}
			
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
	
	@SuppressWarnings("null")
	public Profile getUserProfile(String id)
	{
		PreparedStatement preparedStatement = null;
		Profile profile=null;
		connection  = DBUtils.getConnection();
		ResultSet resultSet = null;
		String insertStatement ="select * from login where userid = ?";
		
		try {
			
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, id);	
		    resultSet = preparedStatement.executeQuery();
			
		    if(resultSet.next())
			{
		    	profile = new Profile();
			 profile.setUserId(resultSet.getString("userid"));
			 profile.setContactNumber(resultSet.getLong("contactno"));
			 profile.setAddress(resultSet.getString("address"));
			 profile.setName(resultSet.getString("name"));
			 profile.setDesignation(resultSet.getString("designation"));
			 profile.setId(resultSet.getInt("id"));
				return profile;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.closeConnection(connection);
		}
		return profile;
	}

}
