package com.wx.leetcode.hot;

public class H55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
