package com.arsoft.projects.common.jms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/receiveFromQueue")
public class JMSQueueConsumer extends HttpServlet {

	private static final long serialVersionUID = -8947771123245679449L;

	@Resource(lookup = JMSConstant.JMS_CONNECTION_FACTORY)
	ConnectionFactory connectionFactory;

	@Resource(lookup = JMSConstant.JMS_QUEUE_ADDRESS)
	Destination destination;

	QueueConnection connection = null;
	QueueSession session = null;
	TextMessage message = null;
	MessageConsumer consumer = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		try {
			connection = (QueueConnection) connectionFactory.createConnection(JMSConstant.JMS_USERNAME,
					JMSConstant.JMS_PASSWORD);
			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			consumer = session.createConsumer(destination);
			connection.start();
			message = (TextMessage) consumer.receive();
			writer.println("Message received is: " + message.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				consumer.close();
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
