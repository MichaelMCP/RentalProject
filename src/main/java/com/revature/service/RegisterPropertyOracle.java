package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Property;
import com.revature.beans.User;
import com.revature.data.PropertyDao;
import com.revature.data.UserDao;

@Service
public class RegisterPropertyOracle implements RegisterPropertyService {
	
	@Autowired
	PropertyDao pd;
	
	@Autowired
	UserDao ud;
	
	@Override
	public Property registerProperty(User user, String address1, String address2, String city,
			String states, int zipcode, double currentRentPrice, double rating, int availability) {
		
		Property p = new Property(0, user, address1, address2, city, states, zipcode, currentRentPrice, rating, availability);
		
		return (Property) pd.registerProperty(p);
	}

	@Override
	public User updateRole(User user) {
		user.setRole(2);
		return (User)ud.updateUser(user);
	}
}
