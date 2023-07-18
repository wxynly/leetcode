package com.wx.leetcode.hot;

public class H416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {  // 每一个元素一定是不可重复放入，所以从大到小遍历
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if (dp[target] == target) {
                return true;
            }
        }
        return dp[target] == target;
    }
}
