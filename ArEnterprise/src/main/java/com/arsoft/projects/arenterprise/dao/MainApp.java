package com.arsoft.projects.arenterprise.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.arsoft.projects.arenterprise.beans.ArBean;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("databaseContext.xml");
		ArBeanJDBCTemplate studentJDBCTemplate = (ArBeanJDBCTemplate) context.getBean("arBeanJDBCTemplate");

		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("Zara", 11);
		studentJDBCTemplate.create("Nuha", 2);
		studentJDBCTemplate.create("Ayan", 15);

		System.out.println("------Listing Multiple Records--------");
		List<ArBean> students = studentJDBCTemplate.listArBeans();

		for (ArBean record : students) {
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}
	}
}
