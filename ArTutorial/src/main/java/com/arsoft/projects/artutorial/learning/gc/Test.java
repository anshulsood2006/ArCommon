package com.arsoft.projects.artutorial.learning.gc;

public class Test
{
    Test i;
    public static void main(String[] args)  
    {
        Test t1 = new Test();
        Test t2 = new Test();
          
                  
        // Till now no object eligible
        // for garbage collection 
        t1 = null;
        
        System.gc();
         
        //now two objects are eligible for
        // garbage collection 
        t2 = null;
         
        // calling garbage collector
       Runtime.getRuntime().gc();
        
    }
 
    @Override
    protected void finalize() throws Throwable 
    { 
        System.out.println("Finalize method called ob object "+this); 
    }
}