package com.wx.leetcode.hot;

//买卖股票的最佳时机II
public class H122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int x = prices[i + 1] - prices[i];
            if (x > 0) {
                sum += x;
            }
        }
        return sum;
    }

    public static int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            int x = prices[i] - dp[i - 1][0];
            if (x > 0) {
                dp[i][1] = dp[i - 1][1] + x;
                dp[i][0] = prices[i];
            } else {
                dp[i][1] = dp[i - 1][1];
                dp[i][0] = Math.min(dp[i - 1][0], prices[i]);
            }
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
    }
}
