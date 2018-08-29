package com.arsoft.projects.common.learning.java8.defaultmethod;

public interface DefaultMethod {
	public String sayHello();
	public default int defaultMethod() {
		return 0;
	}
}
