package com.revature.service;

import com.revature.beans.User;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;

public class LoginOracle implements LoginService{

	UserDao ud = new UserHibernate();
	
	@Override
	public User login(String user, String pass) {
		User u = ud.getUser(user, pass);
		
		if(u != null)
		{
			return u;
		}
		else
		{
			return null;
		}
		
	}

}