package com.arsoft.projects.common.learning.multithreading.exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program called MaxValue.java that finds the maximum value in an array of ints using 4 threads. 
 * You may assume in your threaded code that the array has at least 4 elements.
 * @author zsooans
 *
 */
public class MaxValue {

	public static void main(String[] args) {
		int totalElements = 65496760;
		List<Integer> list = ExerciseUtil.getArrayList(totalElements);
		int size = list.size();
		System.out.println("Size = "+size);
		long start = System.currentTimeMillis();
		int maxValue = getMaxValue(list);
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("Max Value: " +maxValue + " calculated in: "+timeElapsed +" miliseconds");
	}

	private static int getMaxValue(List<Integer> list) {
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
	
	
	
}
