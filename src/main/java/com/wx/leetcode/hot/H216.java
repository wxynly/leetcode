package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

public class H216 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= n) {
            backtracking(k, n, 1, 0);
        }
        return result;
    }

    public void backtracking(int k, int n, int index, int sum) {
        if (sum == n && k == list.size()) {
            result.add(new ArrayList<>(list));
        }
        for (int i = index; i <= 9; i++) {
            if (sum + i > n) {
                break;
            }
            list.add(i);
            sum += i;
            backtracking(k, n, i + 1, sum);
            list.remove(list.size() - 1);
            sum -= i;
        }
    }

}
