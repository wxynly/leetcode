package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H47 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] use;

    public List<List<Integer>> permuteUnique(int[] nums) {
        use = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);
        return result;
    }

    public void dfs(int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !use[i - 1]) {
                continue;
            }
            if (!use[i]) {
                list.add(nums[i]);
                use[i] = true;
                dfs(nums);
                list.remove(list.size() - 1);
                use[i] = false;
            }
        }
    }
}
