package com.arsoft.projects.dukaan;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.common.properties.ArPropertyHandler;

public class ArDukaanUtil {
	
	private final static Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());
	
	public static Address[] getDefaultOrderReceivers() throws AddressException, IOException, ServletException{
		String propertyValue = ArPropertyHandler.getProperty("dukaan.order.receiver.emails");
		StringTokenizer strToken = new StringTokenizer(propertyValue, ",");
		List<Address> recepientsList = null;
		while (strToken.hasMoreTokens()){
			if (recepientsList == null){
				recepientsList = new ArrayList<Address>();
			}
			recepientsList.add(new InternetAddress(strToken.nextToken()));
		}
		Address[] recepients = new Address[recepientsList.size()];
		recepients = recepientsList.toArray(recepients);
		logger.debug("Default order receivers are: "+recepients);
		return recepients;
	}
}
