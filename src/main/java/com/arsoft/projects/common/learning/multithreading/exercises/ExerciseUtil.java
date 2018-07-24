package com.arsoft.projects.common.learning.multithreading.exercises;

import java.util.ArrayList;
import java.util.List;

public class ExerciseUtil {
	
	public static List<Integer> getArrayList(int size){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i ++){
			list.add(i);
		}
		return list;
	}
}
