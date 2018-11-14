package com.arsoft.projects.artutorial.learning.serialization;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ArDeserialization {
	
	public static String FILENAME = "object.ser";
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		ArSerializable objectDes = (ArSerializable) ArSerializable.deSerializeObject(FILENAME);
		System.out.println(objectDes.a);
		System.out.println(objectDes.b);
		System.out.println(objectDes.c);
		System.out.println(objectDes.d);
		System.out.println(objectDes.e);
		System.out.println(objectDes.f);
		System.out.println(objectDes.g);
		System.out.println(objectDes.h);
		System.out.println(objectDes.i);
		System.out.println(ArSerializable.j);
		System.out.println(objectDes.k);
	}
	
}
