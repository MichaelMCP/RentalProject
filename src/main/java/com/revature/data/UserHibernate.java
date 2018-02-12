package com.revature.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.User;
import com.revature.util.HibernateUtil;

public class UserHibernate implements UserDao 
{
	private static Logger log = Logger.getLogger(UserHibernate.class);
	private static HibernateUtil hu = HibernateUtil.getInstance();

	public UserHibernate() 
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createUser(User user) 
	{
		Session session = hu.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			log.warn("The user is: "+user);
			int i = (Integer) session.save(user);
			log.warn("Created user will have an id of "+i);
			log.warn("The user is: "+user);
			
			
			tx.commit();
			
			return user.getId();
			
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}

	}

	@Override
	public User getUser(String username, String password) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(User u) 
	{
		Session su = hu.getSession();
		User user = su.get(User.class, u.getId());
		su.close();
		return user;
	}

	@Override
	public User getUserById(int i) 
	{
		Session su = hu.getSession();
		User user = su.get(User.class, i);
		su.close();
		return user;
	}

	@Override
	public int deleteUser(User user) 
	{
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(user);
		tx.commit();
		s.close();
		return 1;


	}

	@Override
	public User updateUser(User user) 
	{
		Session s = hu.getSession();
		Transaction tx = s.beginTransaction();
		s.update(user);
		tx.commit();
		s.close();
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Session s = hu.getSession();
		String query = "from com.revature.beans.User";
		Query<User> q = s.createQuery(query, User.class);
		List<User> userList = q.getResultList();
		s.close();
		return userList;

	}
}
