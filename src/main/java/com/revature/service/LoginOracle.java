package com.revature.service;

import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;

@Component
public class LoginOracle implements LoginService{

	UserDao ud = new UserHibernate();
	
	@Override
	public User login(String user, String pass) {
		User u = ud.getUser(user, pass);
		User q = ud.getUserById(1);
		return q;
//		if(u != null)
//		{
//			return u;
//		}
//		else
//		{
//			return null;
//		}
		
	}

}
