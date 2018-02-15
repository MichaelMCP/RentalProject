package com.revature.service;

import com.revature.beans.User;

public interface RegisterUserService 
{
	
	public User registerUser(String email, String pass, String fullName, int role);
}
