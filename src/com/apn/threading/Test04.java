package com.apn.threading;

public class Test04 {

	static Object lock = new Object();
	
	static class Run implements Runnable{

		int id;
		
		public Run(int id) {
			this.id = id;
		}
		
		public void run() {
			synchronized(lock) {
				System.out.println("Thread[" + id + "] goes to sleep");
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
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
		
//		System.out.println("# of threads: " + Thread.activeCount());
		
		Thread.sleep(3000);
		
		
		
		synchronized (lock) {			
			System.out.println("Hello from main lock");			
			lock.notifyAll();
		}
		
//		System.out.println("-------------- Done ----------");
	}

}

