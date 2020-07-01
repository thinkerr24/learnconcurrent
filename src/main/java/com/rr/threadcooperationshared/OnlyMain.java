package com.rr.threadcooperationshared;

public class OnlyMain {

	private static class UseThread extends Thread {
		
		@Override
		public void run() {
			String threadName = getName();
			try {
				while (!isInterrupted()) {
					System.out.println(threadName + " I  extend Thread.");
				}
				System.out.println(threadName + " interrupt flag is " + isInterrupted());
			} finally {
				System.out.println("守护线程中finally不能保证执行");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread endThread = new UseThread();
		// 2.将子线程Thread-0设置为main线程的守护线程，它们就共生死
		endThread.setDaemon(true);
		endThread.start();
		Thread.sleep(20);
		// 1. 本来main线程执行完了，然后子线程Thread-0由于没有interrupt，会一直执行
		// endThread.interrupt();
	}

}
