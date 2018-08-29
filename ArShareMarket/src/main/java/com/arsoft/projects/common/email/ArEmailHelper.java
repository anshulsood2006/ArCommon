package com.arsoft.projects.common.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class ArEmailHelper {
	
	
	private static Authenticator authenticator;
	private static Properties emailProperties;
	private static ArEmailHelper emailHelper;
	
	public Authenticator getAutheticator(){
		return ArEmailHelper.authenticator;	
	}
	
	public Properties getProperties(){
		return ArEmailHelper.emailProperties;	
	}
	
	public static ArEmailHelper getInstance(String emailHost, String emailPort, String emailAuthorization, String enableTLs, String emailId, String emailPassword){
		if(emailHelper == null){
			synchronized (ArEmailHelper.class){
				if(emailHelper == null){
					emailHelper = new ArEmailHelper();
					Properties properties = new Properties();
					properties.put("mail.smtp.host", emailHost);
					properties.put("mail.smtp.port", emailPort);
					properties.put("mail.smtp.auth", emailAuthorization);
					properties.put("mail.smtp.starttls.enable", enableTLs);
					Authenticator auth = new Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(emailId, emailPassword);
						}
					};
					ArEmailHelper.authenticator = auth;
					ArEmailHelper.emailProperties = properties;
				}
			}
        }
        return emailHelper;
	}
}
