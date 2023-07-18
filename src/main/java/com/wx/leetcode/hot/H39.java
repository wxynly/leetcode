package com.wx.leetcode.hot;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//组合求和2
public class H39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //排序剪枝
        Arrays.sort(candidates);
        dfs(res, list, candidates, target, 0, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int sum, int index) {
        if (target == sum) {
            res.add(new ArrayList<>(list));
        }

        //剪枝 如果当前数已经大于target，后面也会大于，直接跳过
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                sum += candidates[i];
                list.add(candidates[i]);
                dfs(res, list, candidates, target, sum, i);
                list.remove(list.size() - 1);
                sum -= candidates[i];
            } else {
                break;
            }
        }
    }
}
