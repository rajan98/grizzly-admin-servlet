package com.grizzlystore.service;

import com.grizzlystore.bean.Product;
import java.util.*;
public interface ProductService {
	public String addProduct(Product product);
	public List<Product> getAllProducts();
	public Product findProduct(String id);
	public String deleteProduct(String productId);
	public List<Product> filterProducts(String query);
}