package com.apn.threading;


public class Test02 {

	static Object lock = new Object();
	
	static class Run implements Runnable{

		public void run() {
			synchronized(lock) {
				for(int i = 0; i < 1000; i++) {
					System.out.println("Run " + i);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Run());
		t1.start();
		synchronized (lock) {
			for(int i = 0; i < 1000; i++) {
				System.out.println("Main " + i);
			}
		}
	}

}
