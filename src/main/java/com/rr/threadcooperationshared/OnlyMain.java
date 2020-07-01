package com.rr.threadcooperationshared;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class OnlyMain {

	// 实现Callable接口，允许run方法有返回值
	private static class UseCall implements Callable<String> {

		@Override
		public String call() throws Exception {
			System.out.println("I'm in call()");
			return "CallResult";
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
			FutureTask<String> futureTask = new FutureTask<>(new UseCall());
			// FutureTask实现了Runnable接口
			new Thread(futureTask).start();
			System.out.println(futureTask.get());
	}
	
}
