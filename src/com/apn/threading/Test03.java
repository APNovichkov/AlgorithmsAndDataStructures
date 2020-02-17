package com.apn.threading;

public class Test03 {

	static Object lock = new Object();
	
	static class Run implements Runnable{

		int id;
		
		public Run(int id) {
			this.id = id;
		}
		
		public void run() {
			synchronized(lock) {
				for(int i = 0; i < 20; i++) {
					System.out.println("Run[" + id + "]: " + i);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 10; i++) {
			Thread t = new Thread(new Run(i));
//			Thread.sleep(100);
			t.start();
		}
		
		System.out.println("-------------- Done ----------");
	}

}

