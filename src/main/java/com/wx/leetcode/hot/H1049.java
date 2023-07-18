package com.wx.leetcode.hot;

public class H1049 {
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        if (len <= 1) {
            return stones[0];
        }
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }
}
