package com.wx.leetcode.baidu;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        double res = 0;
        double total = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k - 1) {
                res += nums[i];
            } else {
                total += nums[i];
                count++;
            }
        }
        res += total / count;
        System.out.println(res);
    }
}
