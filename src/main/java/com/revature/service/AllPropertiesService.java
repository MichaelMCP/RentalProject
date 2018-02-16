package com.revature.service;

import java.util.List;

import com.revature.beans.Property;

public interface AllPropertiesService {
	
	public List<Property> getAllProperties();
	
	public void rentProperty(Property P);

}
