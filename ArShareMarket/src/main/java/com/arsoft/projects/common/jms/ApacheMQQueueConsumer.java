package com.arsoft.projects.common.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ApacheMQQueueConsumer {

	public ApacheMQQueueConsumer() throws NamingException, JMSException {
        Message message = null;
        while (message == null){
        	ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JMSConstant.ACTIVE_MQ_URL);
        	Connection connection = connectionFactory.createConnection();
    		connection.start();
    		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(JMSConstant.JMS_QUEUE_ADDRESS);
            MessageConsumer consumer = session.createConsumer(destination);
        	message = consumer.receive(1000);
        	if (message != null){
        		System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
        	}
        	 consumer.close();
             session.close();
             connection.close();
        }
       
	}

	public static void main(String[] args) throws JMSException {
		try {
			new ApacheMQQueueConsumer();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
