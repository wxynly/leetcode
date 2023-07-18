package com.wx.leetcode.hot;

import java.lang.annotation.Target;
import java.util.Arrays;

//完全平方数
public class H279 {
    public static void main(String[] args) {
        numSquares(12);
    }

    //完全背包问题 物品为小于n的每个完全平方数 容量为n
    public static int numSquares(int n) {
        int len = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
