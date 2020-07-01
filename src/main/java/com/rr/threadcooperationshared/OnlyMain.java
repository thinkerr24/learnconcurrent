package com.rr.threadcooperationshared;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class OnlyMain {

	public static void main(String[] args) {
		// 虚拟机线程管理的接口
		ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMxBean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo : threadInfos) {
			System.out.println("[" + threadInfo.getThreadId() + "]" + " " + threadInfo.getThreadName());
		}
	}
}
/**
 *  result:
    [5] Attach Listener     // 获取当前程序运行的各种信息(内存映像, 线程栈...)
	[4] Signal Dispatcher // 分发虚拟机信号
	[3] Finalizer   // Object protect finalize()				
	[2] Reference Handler // 清除引用
	[1] main
 */
