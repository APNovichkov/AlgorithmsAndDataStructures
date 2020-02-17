package com.apn.threading;

public class Test01 {

	static class Run implements Runnable{

		public void run() {
			for(int i = 0; i < 1000; i++) {
				System.out.println("Run " + i);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Run());
		t1.start();
		for(int i = 0; i < 1000; i++) {
			System.out.println("Main " + i);
		}
	}

}
