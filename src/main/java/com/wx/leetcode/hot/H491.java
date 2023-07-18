package com.wx.leetcode.hot;

import java.util.*;

public class H491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        dfs(nums, 0);
        return result;
    }

    public void dfs(int[] nums, int index) {
        if (list.size() >= 2) {
            result.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            //同层、子层需要nus[i]大于List最后一个元素 并且同层不能重复
            if (i > index && set.contains(nums[i]) || list.size() > 0 && nums[i] < list.get(list.size() - 1)) {
                continue;
            }
            list.add(nums[i]);
            set.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
