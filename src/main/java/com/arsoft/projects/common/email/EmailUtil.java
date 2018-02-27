package com.arsoft.projects.common.email;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	
	public static void sendEmail(Map<String, String> order){
		try
	    {
			System.out.println("Email Start");
			String fromEmail = "ar.subsidiary@gmail.com";
			String password = "sood786@";
			String subject = "Order received from "+order.get("NAME");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
	        //create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			//set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress(fromEmail, "Apki Apni Dukaan"));
			msg.setReplyTo(InternetAddress.parse(fromEmail, false));
			msg.setSubject(subject, "UTF-8");
			String message = "Hello!! \n\nNew order received from: "+order.get("NAME")+" ("+order.get("PHONE")+").\n\nThe order needs to be "
					+ "delivered at below address:\n\n"+order.get("ADDRESS") +"\n\nOrder is:\n\n"+order.get("ORDER")+ "\n\nClient can be contacted via E-MAIL at: "+order.get("EMAIL");
			msg.setText(message, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("anshulsood2006@gmail.com", false));
			System.out.println("Message is ready");
			Transport.send(msg);  
			System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}

	public static void main(String[] args) {
		Map<String, String> order = new HashMap<>();
		order.put("NAME", "Anshul");
		order.put("PHONE", "987127577");
		order.put("EMAIL", "anshul.sood@globallogic.com");
		order.put("ADDRESS", "131 Westend Marg Delhi");
		order.put("ORDER", "Rice 10 kg, Sugar 12 kg");
		EmailUtil.sendEmail(order);
	}
}
