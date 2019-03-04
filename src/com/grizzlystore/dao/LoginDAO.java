package com.grizzlystore.dao;

import com.grizzlystore.bean.Profile;

public interface LoginDAO {
	public int getUserStatus(String id);
	public int setUserStatus(String id);
	public Profile getUserProfile(String id);
	public int resetUserStatus(String id);
	public String getUserType(String id,String password);
	public boolean authenticate(String userName,String password);
	public boolean authenticateUserId(String userName);
	

}
