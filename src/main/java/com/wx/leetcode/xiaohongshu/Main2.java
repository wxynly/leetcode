package com.wx.leetcode.xiaohongshu;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        int H = sc.nextInt();
        int[] t = new int[n];
        int[] h = new int[n];
        int[] a = new int[n];
        long[][] dp = new long[T + 1][H + 1];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            h[i] = sc.nextInt();
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < T; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = T; j >= t[i]; j--) {
                for (int k = H; k >= h[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], 0L + dp[j - t[i]][k - h[i]] + a[i]);
                }
            }
        }

        System.out.println(dp[T][H]);
    }
}
