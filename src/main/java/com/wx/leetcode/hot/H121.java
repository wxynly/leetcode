package com.wx.leetcode.hot;

//买卖股票的最佳时机
public class H121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        //每次都求左边区间的最小值，以及当前的最大差值
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i - 1][0]);
        }
        return dp[prices.length - 1][1];
    }
}
