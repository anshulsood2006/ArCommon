package com.arsoft.projects.common.learning.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorInterfaceExample {
	public static void main(String[] args) {
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(new MyRunnable("Anshul"));
		executor.execute(new MyRunnable("Anshul1"));
		executor.execute(new MyRunnable("Anshul2"));
		executor.execute(new MyRunnable("Anshul3"));
		executor.execute(new MyRunnable("Anshul4"));
	}
}
