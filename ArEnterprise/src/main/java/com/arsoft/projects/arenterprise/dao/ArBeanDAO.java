package com.arsoft.projects.arenterprise.dao;

import java.util.List;

import javax.sql.DataSource;

import com.arsoft.projects.arenterprise.beans.ArBean;

public interface ArBeanDAO {
	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	public void setDataSource(DataSource ds);

	/**
	 * This is the method to be used to create a record in the Student table.
	 */
	public void create(String name, Integer age);

	public ArBean getArBean(Integer id);

	/**
	 * This is the method to be used to list down all the records from the Student
	 * table.
	 */
	public List<ArBean> listArBeans();
}
