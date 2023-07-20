package com.wx.leetcode.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCountDown {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        CountDownLatch latchB = new CountDownLatch(1);
        CountDownLatch latchC = new CountDownLatch(1);

        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("A");
                    conditionB.signal();
                    if (i == 0) latchB.countDown();
                    conditionA.await();
                }
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread A");

        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("B");
                    conditionC.signal();
                    if (i == 0) latchC.countDown();
                    conditionB.await();
                }
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread B");

        Thread threadC = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.print("C");
                    conditionA.signal();
                    conditionC.await();
                }
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "Thread C");

        threadA.start();
        threadB.start();
        threadC.start();

    }

}