package com.arsoft.projects.artutorial.learning.java8.methodreference;

import java.util.Arrays;
import java.util.List;

public class InstanceMethodReferenceObjectType {
	public abstract interface MyInterface{
		public String draw();
	}
	public static void main(String args[]) {
        final List<Person> people = Arrays.asList(new Person(), new Person());
		people.forEach(Person::printName);
    }
    private static class Person {
        public String printName() {
			return "";
        }
    }
}
