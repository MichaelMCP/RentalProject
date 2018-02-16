package com.revature.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.beans.Property;
import com.revature.data.PropertyDao;
import com.revature.data.PropertyHibernate;

@Component
public class AllPropertiesOracle implements AllPropertiesService{
	
	PropertyDao pd = new PropertyHibernate();
	
	@Override
	public List<Property> getAllProperties() {
		List<Property> pList = pd.getAllProperties();
		return pList;
	}

	@Override
	public void rentProperty(Property p) {
		p.setAvailability(0);
		pd.updateProperty(p);
		
	}

}
