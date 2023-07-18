package com.wx.leetcode.hot;

public class H977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1;
        int num = nums.length - 1;
        while (l <= r) {
            if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                res[num] = nums[l] * nums[l];
                l++;
            } else {
                res[num] = nums[r] * nums[r];
                r--;
            }
            num--;
        }
        return res;
    }
}
