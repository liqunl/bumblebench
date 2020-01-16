package net.adoptopenjdk.bumblebench.examples;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalHelper {

    // Atomic integer containing the next thread ID to be assigned
     private static final AtomicInteger nextId = new AtomicInteger(0);

     // Thread local variable containing each thread's ID
     private static final ThreadLocal<Integer> threadId =
         new ThreadLocal<Integer>() {
             @Override protected Integer initialValue() {
                 return nextId.getAndIncrement();
         }
     };

     public int getThreadId() {
	return threadId.get();
     }
}

