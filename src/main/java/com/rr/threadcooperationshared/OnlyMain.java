package com.rr.threadcooperationshared;



public class OnlyMain {

	private static class UseThread implements Runnable {
		
		@Override
		public void run() {
			String threadName = Thread.currentThread().getName() ;
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println(threadName + " is running!");
			}
			// 进程标志位
			System.out.println(threadName + " interrput flag is " + Thread.currentThread().isInterrupted());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
			Thread endThread = new Thread(new UseThread());
			endThread.start();
			Thread.sleep(20);
			endThread.interrupt();
	}
	
}
