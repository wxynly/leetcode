package com.wx.leetcode.hot;

import java.util.Arrays;

public class H455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = 0;
        for (int j : s) {
            if (index < g.length && j >= g[index]) {
                index++;
                count++;
            }
        }
        return count;
    }
}
