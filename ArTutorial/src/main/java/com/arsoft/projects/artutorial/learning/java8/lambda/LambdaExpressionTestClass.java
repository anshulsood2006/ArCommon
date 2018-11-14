package com.arsoft.projects.artutorial.learning.java8.lambda;

public class LambdaExpressionTestClass{
	
	public static void main(String[] args) {
		//Before Java 8 using anonymous class
		ILambdaExpressionTestInterfaceNoArgument no = new ILambdaExpressionTestInterfaceNoArgument() {
			@Override
			public String hello() {
				return "Hello";
			}
		};
		
		System.out.println(no.hello());
		
		ILambdaExpressionTestInterfaceOneArgument one = new ILambdaExpressionTestInterfaceOneArgument() {
			
			@Override
			public String hello(String firstName) {
				return "Hello " +firstName;
			}
		};
		
		System.out.println(one.hello("Anshul"));
		
		ILambdaExpressionTestInterfaceTwoArgument two = new ILambdaExpressionTestInterfaceTwoArgument() {
			
			@Override
			public String hello(String firstName, String lastName) {
				return "Hello " +firstName +" "+lastName;
			}
		};
		
		System.out.println(two.hello("Anshul","Sood"));
		
		//After Java 8 using lambda expression
		ILambdaExpressionTestInterfaceNoArgument noLambda = () -> {return "Hello";};
		System.out.println(noLambda.hello());
		
		ILambdaExpressionTestInterfaceOneArgument oneLambda = (firstName) -> {return "Hello " +firstName;};
		System.out.println(oneLambda.hello("Anshul"));
		
		ILambdaExpressionTestInterfaceTwoArgument twoLambda = (firstName, secondName) -> {return "Hello " +firstName +" "+secondName;};
		System.out.println(twoLambda.hello("Anshul","Sood"));
		
	}
	
}
