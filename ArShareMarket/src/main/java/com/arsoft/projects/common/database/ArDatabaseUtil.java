package com.arsoft.projects.common.database;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.config.ConfigurationException;
import org.hibernate.service.ServiceRegistry;

import com.arsoft.projects.arshared.exception.ArException;

public class ArDatabaseUtil {
	
	private final static Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	private static Map<String, SessionFactory> mapSessionFactory;
	
	private ArDatabaseUtil() {
		
	}
		
	public static SessionFactory getSessionFactory(String resource) throws ArException {
		if (resource == null) {
			String exceptionMessage = "Resource can not be null";
			throw new ArException(exceptionMessage, logger);
		}
		logger.debug("Getting session factory for "+resource);
		if (mapSessionFactory == null) {
			mapSessionFactory = new HashMap<>();
		}
		if(mapSessionFactory.get(resource) == null) {
			SessionFactory sessionFactory = buildSessionFactory(resource);
			mapSessionFactory.put(resource, sessionFactory);
		}
		return mapSessionFactory.get(resource);
	}

		private static SessionFactory buildSessionFactory(String resource) throws ArException {
			Configuration configuration = null;
			ServiceRegistry serviceRegistry = null;
			if (resource == null) {
				String exceptionMessage = "Resource can not be null";
				throw new ArException(exceptionMessage, logger);
			}
			 try {
				configuration = new Configuration().configure(resource);
	        	serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	        	if (serviceRegistry == null) {
					String exceptionMessage = "serviceRegistry can not be null";
					throw new ArException(exceptionMessage, logger);
				}
			 }catch (ConfigurationException e) {
				throw new ArException("Resource "+resource+" not found on the classpath");
			}
			return configuration.buildSessionFactory(serviceRegistry);
		}

	public static void shutdown(String resource) throws ArException {
		getSessionFactory(resource).close();
		logger.debug("Successfully shut down session factory for "+resource);
	}
}
