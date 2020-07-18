package com.tianyl.demo.common.util;

public class ThreadUtil {

	public static void safeSleep() {
		safeSleep(5l);
	}

	public static void safeSleep(long second) {
		try {
			Thread.sleep(second * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
