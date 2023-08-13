package com.wx.leetcode.mihayou2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a1 = in.nextInt();
        int b1 = in.nextInt();
        int a2 = in.nextInt();
        int b2 = in.nextInt();
        int a3 = in.nextInt();
        int b3 = in.nextInt();
        int min1 = Math.min(Math.abs(a1 - a2), n - Math.abs(a1 - a2)) + Math.min(Math.abs(b1 - b2), m - Math.abs(b1 - b2));
        int min2 = Math.min(Math.abs(a2 - a3), n - Math.abs(a2 - a3)) + Math.min(Math.abs(b2 - b3), m - Math.abs(b2 - b3));
        System.out.println(min1 + min2);
    }
}