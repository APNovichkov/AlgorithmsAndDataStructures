package com.apn.threading;

public class TestThread {

	static Object lock = new Object();
	
	public static class TestRun implements Runnable{

		@Override
		public void run() {
			System.out.println("Running: started");
			synchronized(lock) {
				try {
					lock.wait();
				} catch(InterruptedException e) {}
			}
			
			
			System.out.println("Running: ended");
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("We are in main");
		Thread.sleep(5000);
		
		Thread t1 = new Thread(new TestRun());
		t1.start();
		
		Thread.sleep(5000);
		synchronized(lock) {
			lock.notifyAll();	
		}
		

	}

}
