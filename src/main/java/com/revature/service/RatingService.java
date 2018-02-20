package com.revature.service;

import java.util.List;

import com.revature.beans.Property;

public interface RatingService {
	
	public List<Property> getRentedProperties(int i);
	
	public Property rateProperty(Property p);

}
