package com.arsoft.projects.artutorial.learning.multithreading.exercises;

import java.util.ArrayList;
import java.util.List;

public class ExerciseUtil {
	
	public static List<Integer> getArrayList(int size){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i ++){
			System.out.println(i);
			if (i == 100){
				list.add(654323456);
			}
			if (i == 63){
				list.add(719999999);
			}
			else{
				list.add(i);
			}
		}
		return list;
	}
}
