package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (length < 3) {
            return lists;
        }
        //排序避免重复
        Arrays.sort(nums);
        for (int first = 0; first < length; first++) {
            //避免重复
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //双指针一个从小到大，一个从大到小排序
            int third = length - 1;
            for (int second = first + 1; second < length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //大于0，Third继续减小
                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }
                //如果指针重合，意味着均大于0，那么随着b增加，依然会如此
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    lists.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (length < 3) {
            return lists;
        }
        //排序避免重复
        Arrays.sort(nums);
        for (int first = 0; first < length; first++) {
            //避免重复
            if (first > 0 && nums[first] == nums[first - 1] || nums[first] > 0) {
                continue;
            }
            //双指针一个从小到大，一个从大到小排序
            int second = first + 1;
            int third = length - 1;
            //如果指针重合，意味着均大于0，那么随着b增加，依然会如此
            while (second < third) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    second++;
                } else if (nums[first] + nums[second] + nums[third] > 0) {  //大于0，Third继续减小
                    third--;
                } else if (nums[first] + nums[second] + nums[third] == 0) {
                    lists.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second++;
                } else {
                    second++;
                }
            }
        }
        return lists;
    }
}
