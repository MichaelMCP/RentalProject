package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Property;
import com.revature.data.PropertyDao;
import com.revature.data.PropertyHibernate;

@Component
public class AllPropertiesOracle implements AllPropertiesService{
	@Autowired
	PropertyDao pd;
	
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
