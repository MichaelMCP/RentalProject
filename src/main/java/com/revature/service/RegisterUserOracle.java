package com.revature.service;

import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.data.UserDao;
import com.revature.data.UserHibernate;

@Component
public class RegisterUserOracle implements RegisterUserService {

	UserDao ud = new UserHibernate();
	
	@Override
	public User registerUser(String email, String pass, String fullName, int role) {
		User nu = new User(0, role, fullName, email, pass);
		ud.createUser(nu);
		return nu;
	}

}
