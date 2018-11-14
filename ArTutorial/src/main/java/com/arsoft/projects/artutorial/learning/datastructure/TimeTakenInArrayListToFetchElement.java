package com.arsoft.projects.artutorial.learning.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program called MaxValue.java that finds the maximum value in an array of ints using 4 threads. 
 * You may assume in your threaded code that the array has at least 4 elements.
 * @author zsooans
 *
 */
public class TimeTakenInArrayListToFetchElement {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100000000; i ++){
			System.out.println(i);
			list.add(i+7);
		}
		System.out.println(list.size());
		int index = 1;
		getTime(list, index);
		index = 10;
		getTime(list, index);
		index = 100;
		getTime(list, index);
		index = 1000;
		getTime(list, index);
		index = 6796;
		getTime(list, index);
		index = 99999;
		getTime(list, index);
		index = 100000;
		getTime(list, index);
		index = 999999;
		getTime(list, index);
		index = 9999;
		getTime(list, index);
		index = 9999991;
		getTime(list, index);
		index = 99999911;
		getTime(list, index);
	}
	
	public static void getTime(List<Integer> list, int index){
		long start = System.currentTimeMillis();
		Integer z = list.get(index);
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println("list.get("+index+"): "+ z + " Time Taken: "+timeElapsed);
	}
}
