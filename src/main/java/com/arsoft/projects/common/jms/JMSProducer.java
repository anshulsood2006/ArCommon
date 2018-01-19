package com.arsoft.projects.common.jms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/send")
public class JMSProducer extends HttpServlet {

	private static final long serialVersionUID = 5043312908505867934L;

	@Resource(lookup = JMSConstant.JMS_QUEUE_CONNECTION_FACTORY)
	ConnectionFactory connectionFactory;

	@Resource(lookup = JMSConstant.JMS_QUEUE_ADDRESS)
	Destination destination;
	
	QueueConnection connection = null;
	QueueSession session = null;
	TextMessage message = null;
	MessageProducer producer = null;
	String messageToSend = "Hello, world! ^__^";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		try {
			connection = (QueueConnection) connectionFactory.createConnection(JMSConstant.JMS_USERNAME,
					JMSConstant.JMS_PASSWORD);
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			producer =  session.createProducer(destination);
			message =  session.createTextMessage(messageToSend);
			producer.send(message);
            writer.println("Message sent! " + messageToSend);
		} catch (JMSException e) {
			e.printStackTrace();
		}finally {
			try {
				producer.close();
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
