package com.grizzlystore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grizzlystore.bean.Category;
import com.grizzlystore.util.DBUtils;

public class CategoryDAOImpl implements CategoryDAO {
	private Connection connection=null;

	@Override
	public List<Category> getCategory() {

		List<Category> allCategory= new ArrayList<>();
		PreparedStatement preparedStatement=null;
		String getString ="Select * from category";
		ResultSet resultSet= null;
		Category category = null;
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(getString);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String id = resultSet.getString("categoryid");
				String name = resultSet.getString("name");
				category = new Category(id,name);
				allCategory.add(category);
			}
			return allCategory;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		
		return null;
	}

}
