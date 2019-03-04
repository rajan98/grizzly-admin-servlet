package com.grizzlystore.service;

import com.grizzlystore.bean.Vendors;
import com.grizzlystore.dao.VendorDAOImpl;

public class VendorServiceImpl implements VendorService {
	private VendorDAOImpl dao = new VendorDAOImpl();
	
	public Vendors getVendorById(String id) {
		// TODO Auto-generated method stub
		return dao.getVendorById(id);
	}

}
