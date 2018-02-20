package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Property;
import com.revature.data.PropertyDao;

@Service
public class AllPropertiesOracle implements AllPropertiesService{
	
	@Autowired
	PropertyDao pd;
	
	@Override
	public List<Property> getAllPropertiesAvailable() {
		return pd.getAllPropertiesAvailable();
		
	}

	@Override
	public void rentProperty(Property p) {
		p.setAvailability(0);
		pd.updateProperty(p);
		
	}

}
