package com.vnet.thread;

public class ExtendThreadTest {

	public static void main(String[] args) {

//		ExtendThread ext = new ExtendThread();
//		ext.start();
		Thread t = new Thread() {
			public void run() {
				for(Integer i = 0; i < 100000; i++) {					
					System.out.println("通过创建Thread的匿名子类... ..." + i);
				}
			}
		};
		t.start();

	}

}
