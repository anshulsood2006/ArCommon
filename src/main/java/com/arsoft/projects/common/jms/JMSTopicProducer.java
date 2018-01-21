package com.arsoft.projects.common.jms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/sendToTopic")
public class JMSTopicProducer  extends HttpServlet  {

	private static final long serialVersionUID = 7074446247418924792L;

	@Resource(lookup = JMSConstant.JMS_CONNECTION_FACTORY)
	ConnectionFactory connectionFactory;

	@Resource(lookup = JMSConstant.JMS_TOPIC_ADDRESS)
	Topic topic;
	
	TopicConnection connection;
	TopicSession session;
	TextMessage textMessage = null;
	TopicPublisher publisher = null;
	String messageToPublish = "Hello, world published!";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		try {
			connection = (TopicConnection) connectionFactory.createConnection(JMSConstant.JMS_USERNAME,
					JMSConstant.JMS_PASSWORD);
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			publisher =  session.createPublisher(topic);
			textMessage =  session.createTextMessage(messageToPublish);
			publisher.send(textMessage);
            writer.println("Message published is: " + textMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		}finally {
			try {
				publisher.close();
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
