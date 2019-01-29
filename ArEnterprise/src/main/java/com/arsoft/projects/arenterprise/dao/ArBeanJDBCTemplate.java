package com.arsoft.projects.arenterprise.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.arsoft.projects.arenterprise.beans.ArBean;

public class ArBeanJDBCTemplate implements ArBeanDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age) {
		String SQL = "insert into test (name, age) values (?, ?)";

		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
		return;
	}

	@Override
	public ArBean getArBean(Integer id) {
		return null;
	}

	@Override
	public List<ArBean> listArBeans() {
		String SQL = "select name, age from test";
		List<ArBean> arBeans = jdbcTemplateObject.query(SQL, new ArBeanMapper());
		return arBeans;
	}
}
