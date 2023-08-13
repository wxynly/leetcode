package com.wx.leetcode.meituan2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int x = in.nextInt();
        int y = in.nextInt();
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                if (a[i - 1] == x && a[i] == y || a[i - 1] == y && a[i] == x) {
                    System.out.println("Yes");
                    return;
                }
            }
            if (i < n - 1) {
                if (a[i] == x && a[i + 1] == y || a[i + 1] == x && a[i] == y) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}
