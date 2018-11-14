package com.arsoft.projects.artutorial.learning;

public class Lambda {
	//has grammer, syntax, expressions, variables -> a lambda can be given to other lambda
	//-(parameters comma separated even without type) -> {body}
	int z = 0;
	
	interface Displyable{
		void display(int x, int y);
	}
	
	public void main(String[] args) {
		Displyable d = (x, y) -> {z = x + y;};
		System.out.println(z);
		d.display(10, 10);
	}
}
