package com.grizzlystore.service;

import com.grizzlystore.service.LoginServiceImpl;
import com.grizzlystore.bean.Profile;
import com.grizzlystore.dao.LoginDAO;
import com.grizzlystore.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {
	
	
	
	private static LoginServiceImpl loginServiceImpl = null;

	private LoginDAO dao = LoginDAOImpl.getInstance();
	
	public static LoginServiceImpl getInstance()
	{
		if(loginServiceImpl == null)
			loginServiceImpl = new LoginServiceImpl();
		return loginServiceImpl;
	}
	
	@Override
	public int getUserStatus(String id) {
	return dao.getUserStatus(id);
	}

	@Override
	public String getUserType(String id,String password) {
		return dao.getUserType(id,password);

	}

	@Override
	public boolean authenticate(String userName,String password) {
		return dao.authenticate(userName,password);

	}
	
	@Override
	public String authorization(String userName,String password)
	{
		return "false";
	}
	
	@Override
	public int setUserStatus(String id)
	{
	return dao.setUserStatus(id);
	}
	
	@Override
	public boolean authenticateUserId(String userName)
	{
		return dao.authenticateUserId(userName);
	}
	
	@Override
	public int resetUserStatus(String id)
	{
		return dao.resetUserStatus(id);
	}
	
	@Override
	public Profile getUserProfile(String id)
	{
		return dao.getUserProfile(id);
	}
	
}
