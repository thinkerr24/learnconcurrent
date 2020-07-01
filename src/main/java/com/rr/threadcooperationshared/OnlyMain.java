package com.rr.threadcooperationshared;



public class OnlyMain {

	private static class UseThread extends Thread {
		
		public UseThread(String name) {
			super(name);
		}
		@Override
		public void run() {
			String threadName = Thread.currentThread().getName() ;
			while (!isInterrupted()) {
				System.out.println(threadName + " is running!");
			}
			// 进程标志位
			System.out.println(threadName + " interrput flag is " + isInterrupted());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
			Thread endThread = new UseThread("endThread");
			endThread.start();
			Thread.sleep(20);
			endThread.interrupt();
	}
	
}
