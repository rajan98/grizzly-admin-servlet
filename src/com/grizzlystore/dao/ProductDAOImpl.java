package com.grizzlystore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grizzlystore.bean.Product;
import com.grizzlystore.util.DBUtils;

public class ProductDAOImpl implements ProductDAO {

	private Connection connection=null;
	
	
	@Override
	public String addProduct(Product product) {
		String query ="insert into product values(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		connection = DBUtils.getConnection();
		
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,product.getId());
			preparedStatement.setString(2, product.getCategory());
			preparedStatement.setString(3, product.getName());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setFloat(5, product.getPrice());
			preparedStatement.setString(6, product.getBrand());
			preparedStatement.setString(7, "0");
			preparedStatement.setString(8, "0");
			
			preparedStatement.executeUpdate();
			return "success";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		return "failed";
		
		
	}
	@Override
	public List<Product> getAllProducts() {
		
		List<Product> products = new ArrayList<Product>();
		PreparedStatement preparedStatement=null;
		String getString ="Select * from product";
		ResultSet resultSet= null;
		Product product = null;
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(getString);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String id = resultSet.getString("productid");
				String category = resultSet.getString("category");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Float price = resultSet.getFloat("price");
				String brand = resultSet.getString("brand");
				String offer = resultSet.getString("offer");
				String rating = resultSet.getString("rating");
				product = new Product(id,category,name,description,price,brand,offer,rating);
				products.add(product);
				
			}
			return products;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		
		return null;
	}
	
	@Override
	public Product findProduct(String id) {
		Product product = null;
		PreparedStatement preparedStatement=null;
		String getString ="Select * from product where productid = ?";
		ResultSet resultSet= null;
		
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(getString);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				String productid = resultSet.getString("productid");
				String category = resultSet.getString("category");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				float price = resultSet.getFloat("price");
				String brand = resultSet.getString("brand");
				String offer = resultSet.getString("offer");
				String rating = resultSet.getString("rating");
				
				product = new Product(productid,category,name,description,price,brand,offer,rating);
			}
			return product;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		
		return null;
	}
	
	@Override
	public String deleteProduct(String productId) {
		PreparedStatement preparedStatement=null;
		String getString ="Delete from product where productid=?";
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(getString);
			preparedStatement.setString(1, productId);
			preparedStatement.executeUpdate();
			return "deleted";
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBUtils.closeConnection(connection);
		}
		
		return null;
	}
	
	@Override
	public List<Product> filterProducts(String query)
	{
		List<Product> products = new ArrayList<Product>();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet= null;
		Product product = null;
		
		try {
			connection = DBUtils.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String id = resultSet.getString("productid");
				String category = resultSet.getString("category");
				String name = resultSet.getString("name");
				String description = resultSet.getString("description");
				Float price = resultSet.getFloat("price");
				String brand = resultSet.getString("brand");
				String offer = resultSet.getString("offer");
				String rating = resultSet.getString("rating");
				product = new Product(id,category,name,description,price,brand,offer,rating);
				products.add(product);
			}
			return products;
			
			
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