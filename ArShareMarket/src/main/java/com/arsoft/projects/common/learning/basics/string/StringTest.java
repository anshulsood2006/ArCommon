package com.arsoft.projects.common.learning.basics.string;

public class StringTest {
	public static void main(String[] args) {
		String s = "This is a test string";
		s.replace("is", "was");
		System.out.println(s);
		s = "This is a test string";
		s.concat("Anshul");
		System.out.println(s);
		s = "This is a test string";
		s.toUpperCase();
		System.out.println(s);
		s = "This is a test string";
		s.valueOf("B");
		System.out.println(s);
	}
}