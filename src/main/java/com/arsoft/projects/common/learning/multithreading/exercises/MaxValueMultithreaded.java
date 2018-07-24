package com.arsoft.projects.common.learning.multithreading.exercises;

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
			//System.out.println("Max: "+index);
			int z = list.get(index);
			if(z > maxValue){
				maxValue = z;
			}
		}
		return maxValue;
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int totalElements = 65496760;
		List<Integer> list = ExerciseUtil.getArrayList(totalElements);
		System.out.println("Array initialized: "+list.size());
		ExecutorService executor = Executors.newFixedThreadPool(10);
		int gap = totalElements / 4;
		int maxValueFinal = 0;
		long start = System.currentTimeMillis();
		for (int i = 0; i < 4; i++){
			Future<Integer> fut = executor.submit(new MaxValueMultithreaded(list.subList(gap * i, gap * (i + 1))));
			Integer maxValue = fut.get();
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
