package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Property;
import com.revature.beans.User;
import com.revature.data.PropertyDao;

public class RegisterPropertyOracle implements RegisterPropertyService {
	
	@Autowired
	PropertyDao pd;
	
	@Override
	public Property registerProperty(User user, String address1, String address2, String city,
			String states, int zipcode, double currentRentPrice, double rating, int availability) {
		
		/*
		 * int propertyId, User owner, String address1, String address2, String city, String state,
			int zipcode, double currentRentPrice, double rating, int availability
		 * */
		Property p = new Property(0, user, address1, address2, city, states, zipcode, currentRentPrice, rating, availability);
		
		
		return (Property) pd.registerProperty(p);
	}

}
