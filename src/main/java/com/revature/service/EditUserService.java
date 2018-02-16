package com.revature.service;

import java.util.List;

import com.revature.beans.User;

public interface EditUserService {
	public List<User> getAllUser();
	public void deleteUser(User u);

}
