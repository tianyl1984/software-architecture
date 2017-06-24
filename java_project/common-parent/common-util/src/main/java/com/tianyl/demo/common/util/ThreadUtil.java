package com.tianyl.demo.common.util;

public class ThreadUtil {

	public static void safeSleep() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
