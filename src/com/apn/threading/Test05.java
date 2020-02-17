package com.apn.threading;

import java.util.concurrent.atomic.AtomicInteger;

public class Test05 {
	
	static Object lock = new Object();
	static AtomicInteger count1 = new AtomicInteger();
	
	static int CYCLES = 1000000;
	static int count = 0;
	
	static class RunPlus implements Runnable{

		@Override
		public void run() {
			for(int i = 0 ; i < CYCLES; i++) {
				synchronized (lock) {
					count++;
				}
				count1.incrementAndGet();
			}
		}		
	}
	

	static class RunMinus implements Runnable{

		@Override
		public void run() {
			for(int i = 0 ; i < CYCLES; i++) {
				synchronized (lock) {
					count--;
				}							
				count1.decrementAndGet();
			}
		}		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new RunPlus());
		Thread t2 = new Thread(new RunMinus());
		t1.start();
		t2.start();
			
		
		Thread.sleep(3000);
		
		System.out.println(count);
		System.out.println(count1.get());
	}
	
	

}
