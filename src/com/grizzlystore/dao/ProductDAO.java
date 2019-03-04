package com.grizzlystore.dao;

import java.util.List;

import com.grizzlystore.bean.Product;

public interface ProductDAO {
	public String addProduct(Product product);
	public List<Product> getAllProducts();
	public Product findProduct(String id);
	public String deleteProduct(String productId);
	public List<Product> filterProducts(String query);
}
