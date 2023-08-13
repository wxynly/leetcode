package com.wx.leetcode.meituan2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        long[] cSum = new long[n];
        long[] rSum = new long[m];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
                sum += a[i][j];
            }
        }
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long temp = 0;
            if (i > 0) {
                temp += cSum[i - 1];
            }
            for (int c = 0; c < m; c++) {
                temp += a[i][c];
            }
            rSum[i] = temp;
            min = Math.min(min, Math.abs(sum - 2 * temp));
        }

        for (int i = 0; i < m; i++) {
            long temp = 0;
            if (i > 0) {
                temp += rSum[i - 1];
            }
            for (int r = 0; r < n; r++) {
                temp += a[r][i];
            }
            rSum[i] = temp;
            min = Math.min(min, Math.abs(sum - 2 * temp));
        }
        System.out.println(min);
    }
}