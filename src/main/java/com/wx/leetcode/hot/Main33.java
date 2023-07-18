package com.wx.leetcode.hot;

public class Main33 {
    static int maxsize = 100;
    static int[] queue = new int[maxsize];
    static int start, end;
    static int count = 0;

    public static void add(int a) {
        if (count == maxsize) {
            throw new RuntimeException("队列已经满了");
        }
        count++;
        queue[end] = a;
        end = (end + 1) % maxsize;
    }

    public static int poll() {
        if (count == 0) {
            throw new RuntimeException("队列为空");
        }
        count--;
        int temp = start;
        start = (start + 1) % maxsize;
        return queue[temp];
    }

    public static int getSize() {
        return count;
    }

    public static void print(int[] nums, int s, int e) {
        for (int i = s; i < e; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            add(i);
        }
        print(queue, start, end);
        System.out.println(count);
        for (int i = 0; i < 5; i++) {
            poll();
        }
        print(queue, start, end);
        System.out.println(count);
    }

}
