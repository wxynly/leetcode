package com.wx.leetcode.hot;

import java.util.concurrent.ForkJoinPool;

public class H63 {
    public static void main(String[] args) {
        uniquePathsWithObstacles(new int[][]{{0, 0}});
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        if (obstacleGrid[0][0] == 1 && obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1 && (i != 0 || j != 0)) {
                    obstacleGrid[i][j] = 0;
                } else {
                    if (i >= 1) {
                        obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                    }
                    if (j >= 1) {
                        obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                    }
                }
            }
        }

        return obstacleGrid[n - 1][m - 1];
    }


    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        //滚动数组
        int[] f = new int[m];
        //特判起点
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                } else {
                    if (j - 1 >= 0) {
                        //已包含上一行结果，加上前一列刷新为本行结果
                        f[j] += f[j - 1];
                    }
                }
            }
        }

        return f[m - 1];
    }
}
