package com.wx.leetcode.test;

public class SyncWaitNotify {

    public static void main(String[] args) {
        Object o = new Object();
        String a;
        StringBuilder b;
        char[] arrInteger = "1234567".toCharArray();
        char[] arrChar = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                for (char c : arrInteger) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                o.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (o) {
                for (char c : arrChar) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }).start();
    }

}