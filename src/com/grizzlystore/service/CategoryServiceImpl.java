package com.grizzlystore.service;

import java.util.List;

import com.grizzlystore.bean.Category;
import com.grizzlystore.dao.CategoryDAO;
import com.grizzlystore.dao.CategoryDAOImpl;

public class CategoryServiceImpl implements CategoryService {
	CategoryDAO dao = new CategoryDAOImpl();
	
	@Override
	public List<Category> getCategory() {
		return  dao.getCategory();
	}

}
