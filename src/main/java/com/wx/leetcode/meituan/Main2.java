package com.wx.leetcode.meituan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, a, b, ans;
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            a = sc.nextInt();
            b = sc.nextInt();
            ans = Math.max(a / n, b / n);
            for (int j = 1; j < n; j++) {
                ans = Math.max(ans, Math.min(a / j, b / (n - j)));
            }
            System.out.println(ans);
        }
    }
}
