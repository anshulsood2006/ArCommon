package com.arsoft.projects.dukaan;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class ArDukaanUtil {
	
	public static Address[] getDefaultOrderReceivers() throws AddressException{
		Address[] recepients = new Address[3];
		recepients[0] = new InternetAddress("anshulsood2006@gmail.com");
		recepients[1] = new InternetAddress("ar.subsidiary@gmail.com");
		recepients[2] = new InternetAddress("shivender.sood@gmail.com");
		return recepients;
	}
}
