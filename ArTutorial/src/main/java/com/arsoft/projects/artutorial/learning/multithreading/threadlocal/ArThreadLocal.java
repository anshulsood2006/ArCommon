package com.arsoft.projects.artutorial.learning.multithreading.threadlocal;

public class ArThreadLocal {
    
    int var1 = 23;
    
    static int var2 = 34;
    
    ThreadLocal<Integer> var3 ;
    
    private class MyThread implements Runnable{
        String name;
        int var1;
        
        MyThread(String name, int var1){ 
             this.name = name;
             this.var1 = var1;
        }

        @Override
        public void run()
        {
            var3 = new ThreadLocal<>();
            var3.set(265);
            System.out.println(this.name + " this.var1: "+this.var1);   
            System.out.println(this.name + " var1: "+var1);  
            System.out.println(this.name + " var2: "+var2);
            System.out.println(this.name + " var3: "+var3.get());
        }
        
    }
    
    public static void main(String[] args)
    {
        ArThreadLocal test = new ArThreadLocal();
        Thread t1 = new Thread(test.new MyThread("T1",13));
        Thread t2 = new Thread(test.new MyThread("T2", 26));
        Thread t3 = new Thread(test.new MyThread("T3", 27));
        t1.start();
        t2.start();
        t3.start();
    }
    
}
