package com.revature.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	/*
	 * This is a utility class for building a SessionFactory and returning
	 * Hibernate Sessions. Note that our SessionFactory will be a singleton
	 * as SessionFactory(ies) are expensive to build and we don't need more
	 * than one SessionFactory to retrieve a large number of sessions.
	 */
	
	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", "jdbc:postgresql://snapster-p2.cxcq8ud9ekvx.us-east-2.rds.amazonaws.com:5432/Snapster") 
					.setProperty("hibernate.connection.username", "username")
					.setProperty("hibernate.connection.password", "password")
					.buildSessionFactory();
		}
		if (sessionFactory == null) {
			System.out.println ("HybernateSessionFactory sessionFactory is NULL");
		}
		return sessionFactory.getCurrentSession();
	}

}
