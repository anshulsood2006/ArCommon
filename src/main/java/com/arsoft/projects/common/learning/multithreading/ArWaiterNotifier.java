package com.arsoft.projects.common.learning.multithreading;

// The class to test the wait and notify/notifyAll
public class ArWaiterNotifier {
	 public static void main(String[] args) {
        ArMessage msg = new ArMessage("process it");
        ArWaiter waiter = new ArWaiter(msg);
        new Thread(waiter).start();
        
        ArWaiter waiter1 = new ArWaiter(msg);
        new Thread(waiter1).start();
        
        ArNotifier notifier = new ArNotifier(msg);
        new Thread(notifier).start();
        System.out.println("All the threads are started");
    }
}
