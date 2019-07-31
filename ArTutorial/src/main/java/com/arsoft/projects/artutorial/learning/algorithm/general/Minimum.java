package com.arsoft.projects.artutorial.learning.algorithm.general;

import java.util.List;

public class Minimum<T extends List<E>, E> {
	private T listOfItems;
	public E minimum;
	
	public Minimum(T listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	public E getMinimum() {
		if (listOfItems == null ||listOfItems.size() == 0) {
			return null;
		}
		
		
		return minimum;
	}
}
