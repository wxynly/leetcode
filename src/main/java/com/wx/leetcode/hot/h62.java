package com.wx.leetcode.hot;

public class h62 {
    int res = 0;

    public int uniquePaths(int m, int n) {
        int[][] num = new int[m][n];
        for (int i = 0; i < n; i++) {
            num[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            num[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                num[i][j] = num[i-1][j] + num[i][j-1];
            }
        }
        return num[m-1][n-1];
    }

    public void dfs(int m, int n, int x, int y) {
        if (x == m && y == n) {
            res++;
            return;
        }
        if (x < m) {
            dfs(m, n, ++x, y);
            x--;
        }
        if (y < n) {
            dfs(m, n, x, ++y);
            y--;
        }
    }
}
