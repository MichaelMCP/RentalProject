package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Property;
import com.revature.beans.RentTransaction;
import com.revature.data.PropertyDao;
import com.revature.data.RentTransactionDao;

@Service
public class RatingOracle implements RatingService{
	
	@Autowired
	RentTransactionDao rd;
	@Autowired
	PropertyDao pd;

	@Override
	public List<Property> getRentedProperties(int i) {
		List<RentTransaction> rList = rd.getRentTransactionByOwnerId(i);
		List<Property> pList = new ArrayList<Property>();
		for(int j = 0; j<rList.size(); j++) {
			pList.add((rList.get(j).getProperty()));
		}
		return pList;
	}

}
