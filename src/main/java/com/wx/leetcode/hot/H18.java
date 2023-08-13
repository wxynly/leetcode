package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;

        Arrays.sort(nums);
        for (int first = 0; first < length; first++) {
            if (first > 0 && nums[first] == nums[first - 1] || nums[first] > 0 && nums[first] > target) {
                continue;
            }
            for (int second = first + 1; second < length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = second + 1;
                int fourth = length - 1;
                while (third < fourth) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        do {
                            third++;
                        } while (third < fourth && nums[third - 1] == nums[third]);
                        do {
                            fourth--;
                        } while (third < fourth && nums[fourth + 1] == nums[fourth]);
                    } else if (sum > target) {
                        fourth--;
                    } else {
                        third++;
                    }
                }
            }
        }
        return res;
    }
}
