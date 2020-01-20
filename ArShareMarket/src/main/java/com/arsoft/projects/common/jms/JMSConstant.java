package com.arsoft.projects.common.jms;

public class JMSConstant {
	public static final String JMS_QUEUE_ADDRESS = "java:/jms/myjmsTest/MyQueue";
	public static final String JMS_TOPIC_ADDRESS = "java:/jms/myjmsTest/MyTopic";
	public static final String JMS_CONNECTION_FACTORY ="java:/jms/myjmsTest/MyConnectionFactory";
	public static final String JMS_USERNAME ="jmsuser";
	public static final String JMS_PASSWORD ="jmsuser@123";
	public static final String ACTIVE_MQ_URL="tcp://arjboss:61616";
	public static final String MESSAGE_TO_PUBLISH = "Hello, world published!";;
}
