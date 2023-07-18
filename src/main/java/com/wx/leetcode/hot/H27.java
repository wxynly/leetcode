package com.wx.leetcode.hot;

public class H27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
                continue;
            }
            if (count > 0) {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public int removeElement1(int[] nums, int val) {
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            } else {
                return 1;
            }
        }
        int left = 0, right = nums.length - 1;
        int temp;
        while (left < right) {
            while (left < right && nums[left] != val) {
                left++;
            }
            while (left < right && nums[right] == val) {
                right--;
            }
            if (left < right) {
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        return left;
    }
}
