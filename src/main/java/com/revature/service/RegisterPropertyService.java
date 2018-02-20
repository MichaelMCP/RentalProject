package com.revature.service;

import com.revature.beans.Property;
import com.revature.beans.User;

public interface RegisterPropertyService {

	public Property registerProperty(User user, String address1, String address2, String city,
			String states, int zipcode, double currentRentPrice, double rating, int availability);
	
	public User updateRole(User user);
	
}
