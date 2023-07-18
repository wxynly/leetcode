package com.wx.leetcode.hot;

//组合总和 Ⅳ
public class H377 {
    //完全背包问题
    //组合数先遍历物品 再遍历容量
    //排列数先遍历容量 再遍历物品
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
