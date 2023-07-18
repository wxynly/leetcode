package com.wx.leetcode.hot;

public class H59 {
    public int[][] generateMatrix(int n) {
        //循环圈数
        int loop = 0;
        //循环开始值
        int start = 0;
        int i, j;
        int[][] res = new int[n][n];
        int count = 1;
        while (loop++ < n >> 1) {
            //从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            //从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            //从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            //从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }

            start++;
        }
        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}
