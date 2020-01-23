package com.arsoft.projects.artutorial.learning.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {
	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(2,3,4,5);
		System.out.println(number);
		Stream<Integer> stream = number.stream();
		System.out.println(stream);
	}
}
