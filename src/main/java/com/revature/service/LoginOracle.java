package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.data.UserDao;

@Service
public class LoginOracle implements LoginService{
	
	@Autowired
	UserDao ud;
	
	@Override
	public User login(String user, String pass) {
		return ud.getUser(user, pass);	
	}

}
