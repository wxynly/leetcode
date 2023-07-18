package com.wx.leetcode.hot;

public class H714 {
    public static int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[][] dp = new int[len][2];
        //当前持有的股票价
        dp[0][0] = prices[0];
        //当前持有的最大值
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            int sub = prices[i] - fee - dp[i - 1][0];
            if (sub > 0) {
                dp[i][0] = prices[i];
                dp[i][1] += dp[i - 1][1] + sub;
            } else {
                dp[i][0] = Math.min(dp[i - 1][0], prices[i]);
                dp[i][1] = dp[i - 1][1];
            }
        }
        return dp[len - 1][1];
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
    }
}
