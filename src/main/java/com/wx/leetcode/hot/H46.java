package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H46 {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] use = new boolean[nums.length];
        dfs(nums, use, list, res);
        return res;
    }

    public static void dfs(int[] nums, boolean[] use, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < use.length; i++) {
            if (!use[i]) {
                list.add(nums[i]);
                use[i] = true;
                dfs(nums, use, list, res);
                list.remove(list.size() - 1);
                use[i] = false;
            }
        }
    }

}
