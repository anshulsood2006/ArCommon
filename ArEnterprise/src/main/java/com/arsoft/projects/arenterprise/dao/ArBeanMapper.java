package com.arsoft.projects.arenterprise.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arsoft.projects.arenterprise.beans.ArBean;

public class ArBeanMapper implements RowMapper<ArBean> {
	public ArBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		ArBean arBean = new ArBean();
		arBean.setAge(rs.getInt("age"));
		arBean.setName(rs.getString("name"));
		return arBean;
	}
}
