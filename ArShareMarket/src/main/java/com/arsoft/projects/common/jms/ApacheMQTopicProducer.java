package com.arsoft.projects.common.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ApacheMQTopicProducer {

	public ApacheMQTopicProducer() throws NamingException, JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JMSConstant.ACTIVE_MQ_URL);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic(JMSConstant.JMS_TOPIC_ADDRESS);
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
        TextMessage message = session.createTextMessage(text);
        System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
        producer.send(message);
        producer.close();
        session.close();
        connection.close();
	}

	public static void main(String[] args) throws JMSException {
		try {
			new ApacheMQTopicProducer();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
