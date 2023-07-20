package com.wx.leetcode.test;

//希望输出是0，但结果几乎每次都不一样
public class IncTest {
	private volatile static int i = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Thread a = new Thread(() -> {
			for( int j = 0 ; j < 1000000 ; j++ ) i++;
		});
		a.start();
		Thread b = new Thread(() -> {
			for( int j = 0 ; j < 1000000 ; j++ ) i--;
		});
		b.start();
		a.join();
		b.join();
		System.out.println(i);
	}
}
