package com.arsoft.projects.arshared.logging;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class ArLoggingUtilTest {
	
	public static AtomicInteger index = new AtomicInteger(2147483647);
	@Test
	public void testLog() {
		ArConsoleLogger.log("This is a sample log");
	}
	
	public static void main(String[] args) {
		try {
			int i = index.incrementAndGet()%2;
			i = index.incrementAndGet()%2;
			i = index.incrementAndGet()%2;
			i = index.incrementAndGet()%2;
			System.out.println(i);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getStackTrace()[0]);
		}
		
	}
}
