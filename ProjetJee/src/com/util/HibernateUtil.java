package com.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	public static SessionFactory sessionFactory;
	public static ServiceRegistry serviceRegistry;
	public static String CONFIG_FILE_LOCATION = "com/util/hibernate.cfg.xml";
	//créer l'objet session Factory
	

	static {
		try {
			Configuration cfg = new Configuration();
			sessionFactory = cfg.configure(CONFIG_FILE_LOCATION)
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	/*private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			//configuration.configure(CONFIG_FILE_LOCATION);
			//serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			return 			configuration.configure(CONFIG_FILE_LOCATION).buildSessionFactory();
		}
		catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object."+ex);
			throw new ExceptionInInitializerError(ex);
			
		}		
		
	}*/
	
	//des méthodes utils
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}	
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	public static void close() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
		sessionFactory=null;
	}
	
	public static final ThreadLocal threadLocal = new ThreadLocal();

	public static Session currentSession() throws HibernateException {

		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {

			if (sessionFactory == null) {
				try {
					 Configuration cfg = new Configuration();
					 sessionFactory = cfg.configure(CONFIG_FILE_LOCATION)
					 .buildSessionFactory();
				} catch (Exception e) {
					System.err.println("Error Creating SessionFactory ");
					e.printStackTrace();
				}
			}

			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}

		return session;
	}

	
	

	/*public static final ThreadLocal threadLocal = new ThreadLocal();

	public static Session currentSession() throws HibernateException {

		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {

			if (sessionFactory == null) {
				try {
					 Configuration cfg = new AnnotationConfiguration();
					 sessionFactory = cfg.configure(CONFIG_FILE_LOCATION)
					 .buildSessionFactory();
				} catch (Exception e) {
					System.err.println("Error Creating SessionFactory ");
					e.printStackTrace();
				}
			}

			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}

		return session;
	}

	public static void closeSession() throws HibernateException {
		sessionFactory.close();
	}
*/
}
