package com.arsoft.projects.common.learning.servlet;

import com.arsoft.projects.common.learning.modifiers.ClassA;

public class ClassC extends ClassA{
	public static void main(String[] args) {
		ClassC a = new ClassC();
		System.out.println(a.publicVariable);
		System.out.println(a.protectedVariable);
	}
}
