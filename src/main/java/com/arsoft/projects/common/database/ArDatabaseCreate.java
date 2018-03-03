package com.arsoft.projects.common.database;

public class ArDatabaseCreate {
	public static void main(String[] args) {
	    ArDatabaseUtil.getSessionFactory();
	    System.out.println("here");
	    ArDatabaseUtil.shutdown();
	}
}
