package com.wx.leetcode.hot;

//打家劫舍II
public class H213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(compute(nums, 0, len - 1), compute(nums, 1, len));
    }

    public int compute(int[] nums, int l, int r) {
        int[] dp = new int[nums.length + 1];
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i < r; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }
        return dp[r - 1];
    }
}
