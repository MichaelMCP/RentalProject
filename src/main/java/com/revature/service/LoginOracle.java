package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.data.UserDao;

@Component
public class LoginOracle implements LoginService{
	
	@Autowired
	UserDao ud;
	
	@Override
	public User login(String user, String pass) {
		User u = ud.getUser(user, pass);		
		return u;
	}

}
