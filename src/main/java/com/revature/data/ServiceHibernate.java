package com.revature.data;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;

import com.revature.beans.Service;
import com.revature.util.HibernateUtil;

public class ServiceHibernate implements ServiceDao{
	
	private static HibernateUtil hu = HibernateUtil.getInstance();

	
	public Service getService(Service serv) {
		Session su = hu.getSession();
		Service s = su.get(Service.class, serv.getId());
		su.close();
		return s;

	}

	@Override
	public List<Service> getServices() {
		Session s = hu.getSession();
		String query = "from com.revature.beans.Service";
		Query<Service> q = s.createQuery(query, Service.class);
		List<Service> serviceList = q.getResultList();
		s.close();
		return serviceList;

	}

}
