package com.arsoft.projects.common.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArStudent implements Comparable<ArStudent> {

	private int age;
	private int rollNumber;
	private String name;
	
	public ArStudent(String name, int age, int rollNumber) {
		this.name = name;
		this.age = age;
		this.rollNumber = rollNumber;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(ArStudent student) {
		if (this.name == null || student.name == null){
			return 0;
		}
		return this.name.compareTo(student.name);
	}
	
	public String toString(){
		return this.name;
	}
	
	public static void main(String[] args) {
		ArStudent a = new ArStudent(null, 0, 0);
		ArStudent b = new ArStudent("A", 10, 1);
		ArStudent c = new ArStudent("z", 10, 2);
		ArStudent d = new ArStudent("P", 11, 3);
		ArStudent e = new ArStudent("Z", 9, 4);
		List<ArStudent> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		System.out.println("Before: "+list);
		Collections.sort(list);
		System.out.println("After: "+list);
	}

}
