package com.arsoft.projects.common.learning.multithreading.exercises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxValueMultithreaded implements Callable<Integer>{

	private List<Integer> list;
	
	public MaxValueMultithreaded(List<Integer> list){
		this.list = list;
	}

	@Override
	public Integer call() throws Exception {
		int maxValue = 0;
		for (int index = 0; index < list.size(); index++){
			int z = list.get(index);
			if(z > maxValue){
				maxValue = z;
			}
		}
		return maxValue;
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int totalElements = 999999999;
		int noOfThreads = 4;
		if (totalElements < 20){
			noOfThreads = 1;
		}
		List<Integer> list = ExerciseUtil.getArrayList(totalElements);
		System.out.println("Array initialized of size : "+list.size());
		ExecutorService executor = Executors.newFixedThreadPool(noOfThreads);
		int gap = totalElements / noOfThreads;
		long start = System.currentTimeMillis();
		Collection<Callable<Integer>> collections = null;
		for (int i = 0; i < noOfThreads; i++){
			if(collections == null){
				collections = new ArrayList<>();
			}
			collections.add(new MaxValueMultithreaded(list.subList(gap * i, gap * (i + 1))));
			
		}
		List<Future<Integer>> list1 = executor.invokeAll(collections);
		int maxValue = 0;
		int maxValueFinal = 0;
		for (Future<Integer> future: list1){
			maxValue = future.get();
			if (maxValue > maxValueFinal){
				maxValueFinal = maxValue;
			}
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Final Max Value is : " + maxValueFinal + " calculated in: " + timeElapsed +" miliseconds");
		executor.shutdownNow();
	}
	
}
