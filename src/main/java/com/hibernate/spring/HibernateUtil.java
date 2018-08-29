package com.hibernate.spring;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	// Hibernate 5:
	private static SessionFactory buildSessionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		
		try {
			 return new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			StandardServiceRegistryBuilder.destroy(registry);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/*
	private static SessionFactory buildSessionFactory() {
		try { 
			System.out.println("Try HibernateUtil");
			return new Configuration().addAnnotatedClass(Message.class).configure().buildSessionFactory();  
		} catch (Throwable ex) {  
			System.err.println("Initial SessionFactory creation failed." + ex);  
			throw new ExceptionInInitializerError(ex);  
		}
	}
	*/
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
