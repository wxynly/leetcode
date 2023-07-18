package com.wx.leetcode.xiecheng;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            if (num[i] < min) {
                min = num[i];
            }
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (num[i] != min) {
                num[i] = num[i] / 2;
                count++;
            }
        }
        System.out.println(count);
    }
}
