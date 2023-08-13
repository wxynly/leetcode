package com.wx.leetcode.meituan2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        if (x == y) {
            System.out.println(0);
            return;
        }
        if (x > y) {
            int temp = y;
            y = x;
            x = y;
        }
        long sum1 = 0;
        for (int i = x; i < y; i++) {
            sum1 += a[i];
        }

        System.out.println(Math.min(sum1, sum - sum1));
    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();

        }
        int x = in.nextInt();
        int y = in.nextInt();
        if (x == y) {
            System.out.println(0);
            return;
        }
        if (x > y) {
            int temp = y;
            y = x;
            x = y;
        }
        long sum1 = 0;
        long sum2 = 0;
        int i = x;
        while (i != y) {
            sum1 += a[i - 1];
            i = i + 1;
        }
        i = x;
        while (i != y) {
            if (i == 1) {
                i = n;
            } else {
                i--;
            }
            sum2 += a[i - 1];
        }

        System.out.println(Math.min(sum1, sum2));
    }
}