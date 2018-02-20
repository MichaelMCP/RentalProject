package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.data.UserDao;
@Component
public class EditUserOracle implements EditUserService {

	@Autowired
	UserDao ud;
	
	@Override
	public List<User> getAllUser() {
		return ud.getAllUsers();
	}

	@Override
	public void deleteUser(User u) {
		ud.deleteUser(u);
		
	}

}