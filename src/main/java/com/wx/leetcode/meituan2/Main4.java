package com.wx.leetcode.meituan2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int j = n / i;
                min = Math.min(min, compute(s, i, j));
            }
        }
        System.out.println(min);
    }

    public static int compute(String s, int r, int c) {
        char[][] nums = new char[r][c];
        boolean[][] flag = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                nums[i][j] = s.charAt(i * c + j);
            }
        }
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!flag[i][j]) {
                    dfs(nums, flag, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] nums, boolean[][] flag, int i, int j) {
        int r = nums.length;
        int c = nums[0].length;
//        if (i < 0 || i >= r || j < 0 || j >= c) {
//            return;
//        }
        flag[i][j] = true;
        if (i > 0 && nums[i - 1][j] == nums[i][j] && !flag[i - 1][j]) {
            dfs(nums, flag, i - 1, j);
        }
        if (i < r - 1 && nums[i + 1][j] == nums[i][j] && !flag[i + 1][j]) {
            dfs(nums, flag, i + 1, j);
        }
        if (j > 0 && nums[i][j - 1] == nums[i][j] && !flag[i][j - 1]) {
            dfs(nums, flag, i, j - 1);
        }
        if (j < c - 1 && nums[i][j + 1] == nums[i][j] && !flag[i][j + 1]) {
            dfs(nums, flag, i, j + 1);
        }
    }
}