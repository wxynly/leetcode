package com.wx.leetcode.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//题目： 100个任务分10批，每批必须等上一批执行完才能开始执行，每批任务内并发执行
public class VolatileTest {
     ExecutorService executorService = Executors.newCachedThreadPool();
     volatile int a = 0;

    //每批任务为同步执行
    public  void doWork() {
        executorService.execute(()->{
            for (int i = 0; i < 1000; i++) {
                a=a+1;
            }
        });
        System.out.println(a);
    }

    public static void main(String[] args) {
        VolatileTest task = new VolatileTest();
        //顺序执行10批任务
        for (int i = 0; i < 10; i++) {
           task.doWork();
        }
    }
}
