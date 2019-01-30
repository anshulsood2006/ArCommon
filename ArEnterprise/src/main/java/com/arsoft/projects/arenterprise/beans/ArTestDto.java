package com.arsoft.projects.arenterprise.beans;

public class ArTestDto {
	
	private int id;
	private String name;
	private int age;
	//private String clazz;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	/*public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}*/
	@Override
	public String toString() {
		return "ArTestDto [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
