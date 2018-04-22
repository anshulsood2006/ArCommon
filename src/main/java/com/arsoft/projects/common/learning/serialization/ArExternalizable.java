package com.arsoft.projects.common.learning.serialization;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ArExternalizable implements Externalizable{

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
	
	public ArExternalizable(String str) {
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
	
	public ArExternalizable() {
		
	}

	public static String FILENAME = "object.ser";
	
	public static void serializeObject(ArExternalizable object) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
		object.writeExternal(oos);
		oos.flush();
		oos.close();
	}
	
	public static Object deSerializeObject(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
		ArExternalizable object = new ArExternalizable();
		object.readExternal(ois);
		ois.close();
		return object;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArExternalizable object = new ArExternalizable("");
		serializeObject(object);
		ArExternalizable objectDes = (ArExternalizable) deSerializeObject(FILENAME);
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
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(e);	
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		e = in.readInt();	
	}

}
