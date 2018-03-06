package com.arsoft.projects.common.environment;

public enum ArEnvironmentAction {
	
	GET_PROPERTY_VALUE("get_property_value"),
	GET_DATABASES("get_database"),
	GET_TABLE_NAME("get_table_name");
	
	private String environmentAction;
	
	private ArEnvironmentAction(String environmentAction) {
		this.environmentAction = environmentAction;
	}
	
	public String getValue() {
		return this.environmentAction;
	}
	
	public static ArEnvironmentAction[] getAllArEnvironmentAction() {
		return ArEnvironmentAction.values();
	}
	
}
