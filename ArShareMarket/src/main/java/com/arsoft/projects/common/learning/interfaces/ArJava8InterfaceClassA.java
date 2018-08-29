package com.arsoft.projects.common.learning.interfaces;

public class ArJava8InterfaceClassA implements ArJava8Interface, ArJava8InterfaceA{

	@Override
	public void write(String text) {
				
	}
	
	@Override
	public void log(String logText) {
		ArJava8InterfaceA.super.log(logText +" Here I come");
	}

	public static void main(String[] args) {
		ArJava8InterfaceClassA a = new ArJava8InterfaceClassA();
	}

}
