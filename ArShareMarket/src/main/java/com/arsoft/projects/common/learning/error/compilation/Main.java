package com.arsoft.projects.common.learning.error.compilation;

public class Main {
	static{
		System.out.println("Static block of "+Thread.currentThread().getStackTrace()[1].getClassName() +" class called.");
	}
	
	public Main(){
		System.out.println("Constructor of "+this.getClass().getName() +" class called.");
	}
	
	public void methodOne(){
		System.out.println("methodOne() of "+this.getClass().getName() +" class called.");
	}
	
	/**Methods can be overloaded by changing the number of arguments 
	 * 
	 * E.g. {@link Main#methodOne()} overrides {@link Main#methodOne(String)} 
	 * 
	 * @param str Argument of type String
	 */
	public void methodOne(String str){
		System.out.println("methodOne(String str) of "+this.getClass().getName() +" class called.");
	}
	
	/**Methods can be overloaded by making it static and changing the number of arguments 
	 * 
	 * E.g. {@link Main#methodOne(String, int)} overrides {@link Main#methodOne(String)} 
	 * 
	 * @param str Argument of type String
	 * @param integer Argument of type Integer
	 *  
	 */
	public static void methodOne(String str, int integer){
		System.out.println("methodOne(String str, int integer) of "+Thread.currentThread().getStackTrace()[1].getClassName() +" class called.");
	}
	
	
	/** Methods can not be overloaded by changing the return type
	 *  <pre>
	 * 	public String methodOne(){
	 *			System.out.println("method one of "+this.getClass().getName() +" class called.");
	 *  	}
	 *  </pre>
	 *  
	 *  
	 *  Methods can not be overloaded by just adding static
	 *  <pre>
	 * 	public static String methodOne(){
	 *			System.out.println("method one of "+this.getClass().getName() +" class called.");
	 *  	}
	 *  </pre>
	 * @param args Arguments passed to the main method
 	*/
	
	public static void main(String[] args) {
		Parent parent = new Child();
		parent.methodOne();
		Main main = new Main();
		main.methodOne();
	}
	
}
