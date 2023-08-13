package com.wx.leetcode.xinhuankeji;

import java.util.Scanner;

public class Main3 {
    static int[] nums;
    static int res;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            res = Integer.MAX_VALUE;
            int num = in.nextInt();
            nums = new int[num];
            for (int i = 0; i < num; i++) {
                nums[i] = in.nextInt();
            }
            dfs(0, 0, 0, true, false);
            dfs(0, 0, 0, false, true);
            System.out.println(res);
        }
    }

    public static void dfs(int cur, int left, int right, boolean l, boolean r) {
        if (cur == nums.length) {
            if (left * right < 0) {
                Math.min(res, right - left);
            } else {
                Math.min(res, Math.max(Math.abs(right), Math.abs(left)));
            }
            return;
        }
        if (l) {
            dfs(cur + 1, left - nums[cur], right, true, false);
            dfs(cur + 1, left + nums[cur], right, false, true);
        } else {
            dfs(cur + 1, left, right - nums[cur], true, false);
            dfs(cur + 1, left, right + nums[cur], false, true);
        }

    }

}
