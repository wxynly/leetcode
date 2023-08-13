package com.wx.leetcode.xinhuankeji;

import sun.plugin.cache.OldCacheEntry;

import java.util.Scanner;

public class Main2 {
    static int[] nums;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int num = in.nextInt();
            nums = new int[num];
            for (int i = 0; i < num; i++) {
                nums[i] = in.nextInt();
            }
            dfs(0, 0, 0, 0);
            System.out.println(res);
        }
    }

    public static void dfs(int cur, int minD, int maxD, int overlap) {
        if (cur == nums.length) {
            res = Math.min(overlap, res);
        }
        if (res < overlap) {
            return;
        }
        int num = nums[cur];

        if (maxD == minD) {
            if (num >= maxD) {
                dfs(cur + 1, 0, minD + num, minD + num);
            } else {
                dfs(cur + 1, Math.min(minD + num, maxD - num), Math.max(minD + num, maxD - num), overlap);
            }
        } else {
            if (num >= maxD) {
                dfs(cur + 1, 0, minD + num, minD + num);
            } else {
                dfs(cur + 1, Math.min(minD + num, maxD - num), Math.max(minD + num, maxD - num), overlap);
            }
            if (num >= minD) {
                dfs(cur + 1, 0, maxD + num, maxD + num);
            } else {
                dfs(cur + 1, minD - num, maxD + num, overlap);
            }
        }
    }

}
