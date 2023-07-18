package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, res, 0, list);
        return res;
    }

    public static void dfs(int[] nums, List<List<Integer>> res, int index, List<Integer> list) {
        if(list.size()<=nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, res, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        subsets(ints);
    }
}
