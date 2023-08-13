package com.wx.leetcode.xinhuankeji;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        int count = 0;
//        for (int i = 1; i <= num; i++) {
//            int x = (int) Math.sqrt(i);
//            if (i == x * x) {
//                count++;
//            }
//        }

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int count = (int) Math.sqrt(num);
        System.out.println(count);
        System.out.println(num + count * (count - 1));
    }
}