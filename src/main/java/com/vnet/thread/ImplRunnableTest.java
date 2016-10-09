package com.vnet.thread;

public class ImplRunnableTest {

	public static void main(String[] args) {
//		Thread t = new Thread(new ImplRunnable());
//		t.start();
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("通过实现Runnable的匿名子类... ...");
			}
		};
		Thread t = new Thread(r);
		t.start();
	}

}