package com.arsoft.projects.common.email;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.arsoft.projects.dukaan.ArDukaanUtil;

public class ArEmailUtil {
	
	public static void sendEmail(String subject, String from, String messageBody, Address[] recepients){
		try
	    {
			System.out.println("Email Start");
			String fromEmail = "ar.subsidiary@gmail.com";
			String password = "sood786@";
			ArEmailHelper arEmailHelper = ArEmailHelper.getInstance("smtp.gmail.com", "587", "true", "true", fromEmail, password);
			Session session = Session.getInstance(arEmailHelper.getProperties(), arEmailHelper.getAutheticator());
			MimeMessage msg = new MimeMessage(session);
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress(fromEmail, from));
			msg.setReplyTo(InternetAddress.parse(fromEmail, false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(messageBody, "UTF-8");
			msg.setSentDate(new Date());
			msg.setRecipients(Message.RecipientType.TO, recepients);
			System.out.println("Message is ready");
			Transport.send(msg);  
			System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}

	public static void main(String[] args) throws AddressException {
		Map<String, String> order = new HashMap<>();
		order.put("NAME", "Anshul");
		order.put("PHONE", "987127577");
		order.put("EMAIL", "anshul.sood@globallogic.com");
		order.put("ADDRESS", "131 Westend Marg Delhi");
		order.put("ORDER", "Rice 10 kg, Sugar 12 kg");
		String subject = "Order received from "+order.get("NAME");
		String from = "Apki Apni Dukaan";
		String messageBody = "Hello!! \n\nNew order received from: "+order.get("NAME")+" ("+order.get("PHONE")+").\n\nThe order needs to be "
				+ "delivered at below address:\n\n"+order.get("ADDRESS") +"\n\nOrder is:\n\n"+order.get("ORDER")+ "\n\nClient can be contacted via E-MAIL at: "+order.get("EMAIL");
		ArEmailUtil.sendEmail(subject, from, messageBody, ArDukaanUtil.getDefaultOrderReceivers());
	}
}
