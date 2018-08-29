package com.arsoft.projects.common.learning.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class ArEnumeration {
	
	public static void main(String[] args) {
		List<String> list = null;
		list = new ArrayList<>();
		list.add("Anshul");
		list.add("Akhil");
		list.add("Abhishek");
		list.add("Ashok");
		Enumeration<String> e = Collections.enumeration(list);
		while (e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
		Vector<String> vector = new Vector<>();
		vector.add("Anshul");
		vector.add("Akhil");
		vector.add("Abhishek");
		vector.add("Ashok");
		e = vector.elements();
		while (e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
	}
	
}
