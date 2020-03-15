package com.arsoft.projects.artutorial.learning.solidprinciples.liskovsubstitution;

public class LSP {
	
	public void calculateArea(Rectangle r) {
		r.setBreadth(2);
		r.setLength(3);
		System.out.println(r.getArea());
	}

	public static void main(String[] args) {
		LSP lsp = new LSP();
		lsp.calculateArea(new Rectangle());
		lsp.calculateArea(new Square());
	}
}
