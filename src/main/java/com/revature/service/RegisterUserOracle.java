package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.data.UserDao;

@Service
public class RegisterUserOracle implements RegisterUserService {

	@Autowired
	UserDao ud;
	
	@Override
	public User registerUser(String email, String pass, String fullName, int role) {
		User nu = new User(0, role, fullName, email, pass);
		ud.createUser(nu);
		return nu;
	}

}
