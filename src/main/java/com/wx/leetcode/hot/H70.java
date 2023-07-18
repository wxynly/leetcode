package com.wx.leetcode.hot;

public class H70 {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        if (n == 1) {
            return a;
        }

        if (n == 2) {
            return b;
        }
        int x = 0;
        for (int i = 3; i <= n; i++) {
            x = a + b;
            a = b;
            b = x;
        }
        return x;
    }
}
