package com.arsoft.projects.artutorial.learning.multithreading.threadlocal;

public class ArThreadLocal {
    
    ThreadLocal<Employee> var1 = new ThreadLocal<Employee>();
    Employee var2 = new Employee("Akhil", 29);
    
    private class MyThread implements Runnable{
        String name;
        MyThread(String name){ 
             this.name = name;
        }
        @Override
        public void run()
        {
            var1.set(new Employee("Anshul", 12));
            System.out.println(this.name + ": Local Varible: "+var2);
            System.out.println(this.name + ": Thread Local Variable: "+var1.get());
        }
    }
    
    private class Employee{
        String name;
        int id;
        public Employee(String name, int id){
            this.name = name;
            this.id = id;
        }
    }
    
    public static void main(String[] args)
    {
        ArThreadLocal test = new ArThreadLocal();
        Thread t1 = new Thread(test.new MyThread("T1"));
        Thread t2 = new Thread(test.new MyThread("T2"));
        Thread t3 = new Thread(test.new MyThread("T3"));
        try
        {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.join();
            t3.start();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    } 
}
