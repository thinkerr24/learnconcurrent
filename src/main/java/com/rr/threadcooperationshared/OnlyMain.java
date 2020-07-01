package com.rr.threadcooperationshared;

public class OnlyMain {

	private static class UseThread extends Thread {

		public UseThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			String threadName = getName();
			while (!isInterrupted()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println(threadName + " interrupt flag is " + isInterrupted());
					// 方法中发生异常, 线程的中断标志位会被复位成false，如果确实是需要中断线程，要求我们自己在catch语句块里再次调用interrupt()
					interrupt();
					e.printStackTrace();
				}

				System.out.println(threadName);
			}

			System.out.println(threadName + " interrupt flag is " + isInterrupted());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread endThread = new UseThread("HasInterrputException");
		endThread.start();
		Thread.sleep(20);
		endThread.interrupt();
	}

}
