package com.wx.leetcode.hot;

public class H343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                int maxA = Math.max(i - j, dp[i - j]);
                int maxB = Math.max(j, dp[j]);
                dp[i] = Math.max(dp[i], maxA * maxB);
            }
        }
        return dp[n];
    }
}
