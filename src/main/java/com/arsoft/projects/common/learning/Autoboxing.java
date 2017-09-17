package com.arsoft.projects.common.learning;

/**
 * This class explains autoboxing
 * @author anshul.sood
 *
 */
public class Autoboxing {
	public static void main(String[] args) {
		int primitive = 100;
		call(primitive);
	}

	/**
	 * Passed as a parameter to a method that expects an object of the corresponding wrapper class. For example a method with Integer argument can be called by passing int, java compiler will do the conversion of int to Integer.
	 * Assigned to a variable of the corresponding wrapper class. For example, assigning a Long object to long variable.
	 * @param wrapped
	 */
	private static void call(Integer wrapped) {
		int primitive  = wrapped;
		wrapped = new Integer(primitive);
		wrapped = primitive;
	}
}
