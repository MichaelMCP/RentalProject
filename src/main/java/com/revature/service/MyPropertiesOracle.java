package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Property;
import com.revature.data.PropertyDao;

@Service
public class MyPropertiesOracle implements MyPropertiesService {
	@Autowired
	PropertyDao pd;
	@Override
	public List<Property> getMyProperties(int id) {
		List<Property> propertiesList = pd.getAllPropertiesByOwnerId(id);
		
		return propertiesList;
	}
	@Override
	public void deleteMyProperty(Property property) {
		pd.deleteProperty(property);
	}
	

}
