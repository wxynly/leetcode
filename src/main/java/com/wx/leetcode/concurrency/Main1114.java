package com.wx.leetcode.concurrency;

import java.util.concurrent.Semaphore;

public class Main1114 {

    public Main1114() {
    }

    private Semaphore two = new Semaphore(0);
    private Semaphore three = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public int reverse(int x) {

        if (x == 0)
            return 0;
        if (x % 10 == 0)
            x = x % 10;
        String result = "";
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }
        result = new StringBuffer(String.valueOf(x)).reverse().toString();
        Long res = Long.valueOf(result);
        if (flag)
            res = -res;
        if (res > Math.pow(2, 31) - 1 || res < Math.pow(-2, 31))
            return 0;
        return 0;
    }

}
