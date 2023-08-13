package com.wx.leetcode.hot;

public class H931 {
    int res = Integer.MAX_VALUE;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, n, 0);
        }
        return res;
    }

    public void dfs(int[][] matrix, int row, int col, int n, int sum) {
        if (row == n) {
            res = Math.min(res, sum);
        }

        if (col >= 0 && col < n && row >= 0 && row < n) {
            sum += matrix[row][col];
            dfs(matrix, row + 1, col - 1, n, sum);
            dfs(matrix, row + 1, col, n, sum);
            dfs(matrix, row + 1, col + 1, n, sum);
            sum -= matrix[row][col];
        }
    }

    public static int minFallingPathSum2(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = dp[i - 1][j];
                if (j - 1 >= 0) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j + 1 < n) {
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                dp[i][j] = min + matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] num = {{17,82},{1,-44}};
        System.out.println(minFallingPathSum2(num));;
    }
}
