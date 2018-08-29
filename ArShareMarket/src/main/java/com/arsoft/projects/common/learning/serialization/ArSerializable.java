package com.arsoft.projects.common.learning.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ArSerializable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7531061384523331594L;
	
	public boolean a ;
	public byte b;
	public transient char c;
	public short d;
	public int e;
	public float f;
	public long g;
	public double h;
	public transient int i;
	public static int j;
	public int k;
	
	public ArSerializable() {
		this.a = true;
		this.b = -128;
		this.c = 'q';
		this.d = -32768;
		this.e = 1234;
		this.f = 1234.9f;
		this.g = 123L;
		this.h = 123.45d;
		this.i = 123;
		j = 15678;
		k = 100;
	}
	
	public static String FILENAME = "object.ser";
	
	public static void serializeObject(Object object) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
		oos.writeObject(object);
		oos.close();
	}
	
	public static Object deSerializeObject(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
		Object object = ois.readObject();
		ois.close();
		return object;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArSerializable object = new ArSerializable();
		serializeObject(object);
		ArSerializable objectDes = (ArSerializable) deSerializeObject(FILENAME);
		System.out.println(objectDes.a);
		System.out.println(objectDes.b);
		System.out.println(objectDes.c);
		System.out.println(objectDes.d);
		System.out.println(objectDes.e);
		System.out.println(objectDes.f);
		System.out.println(objectDes.g);
		System.out.println(objectDes.h);
		System.out.println(objectDes.i);
		System.out.println(j);
	}
	
}
