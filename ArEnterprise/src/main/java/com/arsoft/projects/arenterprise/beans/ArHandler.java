package com.arsoft.projects.arenterprise.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ArHandler {
	
	private ArTestDao arTestDao;
	
	@Autowired
	public void setArTestDao(ArTestDao arTestDao) {
		this.arTestDao = arTestDao;
	}
	
	public void init() {
		List<ArTestDto> arTestDaoList= arTestDao.getAllArTestDto();
		System.out.println(arTestDaoList);
	}
}
