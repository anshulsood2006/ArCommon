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
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/receiveFromTopic")
public class JMSTopicConsumer  extends HttpServlet {

	private static final long serialVersionUID = -5851153897287251352L;
	
	@Resource(lookup = JMSConstant.JMS_CONNECTION_FACTORY)
	ConnectionFactory connectionFactory;

	@Resource(lookup = JMSConstant.JMS_TOPIC_ADDRESS)
	Topic topic;
	
	TopicConnection connection;
	TopicSession session;
	TextMessage textMessage = null;
	TopicSubscriber subscriber = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		try {
			connection = (TopicConnection) connectionFactory.createConnection(JMSConstant.JMS_USERNAME,
					JMSConstant.JMS_PASSWORD);
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			subscriber =  session.createSubscriber(topic);
			connection.start();
			textMessage =  (TextMessage) subscriber.receive();
            writer.println("Message subscribed is: " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}finally {
			try {
				subscriber.close();
				session.close();
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
