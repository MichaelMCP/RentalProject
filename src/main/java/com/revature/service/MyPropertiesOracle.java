package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.beans.Property;
import com.revature.data.PropertyDao;
import com.revature.data.PropertyHibernate;

@Component
public class MyPropertiesOracle implements MyPropertiesService {

	PropertyDao pd = new PropertyHibernate();
	@Override
	public List<Property> getMyProperties(int id) {
		List<Property> propertiesList = pd.getAllPropertiesByOwnerId(id);
		
		return propertiesList;
	}
	public void deleteMyProperties(Property property) {
		pd.deleteProperty(property);
	}

}
