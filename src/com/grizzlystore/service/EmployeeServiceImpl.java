package com.grizzlystore.service;

import com.grizzlystore.bean.Profile;
import com.grizzlystore.dao.EmployeeDAO;
import com.grizzlystore.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDAO dao = new EmployeeDAOImpl();
	@Override
	public int registerUser(Profile employee) {
		// TODO Auto-generated method stub
		return dao.registerUser(employee);
	}

}
