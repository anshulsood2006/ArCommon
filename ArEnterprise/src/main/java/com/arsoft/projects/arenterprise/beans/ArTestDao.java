package com.arsoft.projects.arenterprise.beans;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("HibernateArTestDao")
@Transactional
public class ArTestDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<ArTestDto> getAllArTestDto(){
		return hibernateTemplate.loadAll(ArTestDto.class);
	}
}
