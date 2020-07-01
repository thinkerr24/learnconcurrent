package com.rr.threadcooperationshared;

public class OnlyMain {

	 
	private static class UseThread implements Runnable {
		private volatile int a = 0;	
		@Override
		public void run() {
			a = a + 1;
			System.out.println(Thread.currentThread().getName() + " "  + a);
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				e.printStackTrace();
			}
			a += 1;
			System.out.println(Thread.currentThread().getName() + " "  + a);
		}
			
	}

	public static void main(String[] args) throws InterruptedException {
		UseThread v = new UseThread();
		
		Thread t1 = new Thread(v);
		Thread t2 = new Thread(v);
		Thread t3 = new Thread(v);
		Thread t4 = new Thread(v);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
