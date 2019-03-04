package com.grizzlystore.service;

import java.util.List;

import com.grizzlystore.bean.Product;
import com.grizzlystore.dao.ProductDAO;
import com.grizzlystore.dao.ProductDAOImpl;

public class ProductServiceImpl implements ProductService {

	ProductDAO dao = new ProductDAOImpl();
	@Override
	public String addProduct(Product product) {
		return dao.addProduct(product);
	}
	

	@Override
	public List<Product> getAllProducts() {
		
		return dao.getAllProducts();
	}
		
	@Override
	public Product findProduct(String id)
	{
		return dao.findProduct(id);
	}
	
	@Override
	public String deleteProduct(String productId) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(productId);
	}
	
	@Override
	public List<Product> filterProducts(String query)
	{
		return dao.filterProducts(query);
	}

}
