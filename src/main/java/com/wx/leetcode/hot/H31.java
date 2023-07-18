package com.wx.leetcode.hot;

public class H31 {
    public void nextPermutation(int[] nums) {
        int temp;
        boolean flag = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
                flag = true;
                break;
            }
        }
        if (flag) {
            int i = 0;
            int j = nums.length-1;
            while (i < j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
    }
}
