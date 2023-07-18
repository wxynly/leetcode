package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

public class H77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int n, int k, int index, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            dfs(n, k, index + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
