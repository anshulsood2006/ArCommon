package com.arsoft.projects.common.learning;

/**
 * This class explains unboxing
 * @author anshul.sood
 *
 */
public class Unboxing {
	public static void main(String[] args) {
		Integer wrapped = new Integer(100);
		call(wrapped);
	}

	/**
	 * Passed as a parameter to a method that expects a value of the corresponding primitive type.
	 * Assigned to a variable of the corresponding primitive type.
	 * 
	 * @param wrapped
	 */
	private static void call(int primitive) {
		System.out.println("Integers (wrapped) object has been unboxed to primitive int (primitive)");	
		@SuppressWarnings("unused")
		Integer wrapped = primitive;
		System.out.println("Primitive int (primitive) object has been assigned to Integers (wrapped) object");
	}
}