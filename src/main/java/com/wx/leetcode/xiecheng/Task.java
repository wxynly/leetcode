package com.wx.leetcode.xiecheng;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//题目： 100个任务分10批，每批必须等上一批执行完才能开始执行，每批任务内并发执行
public class Task {
    ExecutorService executorService = Executors.newCachedThreadPool();

    //每批任务为同步执行
    public void doWork(int k) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        //每批任务内通过线程池并发执行，通过CountDownLatch限制需要每批任务的每个任务都执行完成才算结束
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(() -> {
                System.out.println("批次" + k + "-任务" + finalI + "执行中...");
                //任务执行完
                countDownLatch.countDown();
            });
        }
        try {
            //等待所有任务执行完
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        //顺序执行10批任务
        for (int i = 0; i < 10; i++) {
            task.doWork(i);
        }
    }
}
