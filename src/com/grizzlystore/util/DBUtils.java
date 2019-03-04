package com.grizzlystore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
	
	public final static String URL="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String driverName = "oracle.jdbc.driver.OracleDriver";
	public static final String userName="admin";
	public static final String password = "root";
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(URL,userName,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection)
	{
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}