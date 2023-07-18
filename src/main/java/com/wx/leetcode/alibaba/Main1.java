package com.wx.leetcode.alibaba;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {

            for (; j < n; ) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.get(nums[j]) >= k) {
                    sum += n - j;
                    map.put(nums[i], map.get(nums[i]) - 1);
                    break;
                } else {
                    j++;
                }
            }

        }
        System.out.println(sum);
    }
}
