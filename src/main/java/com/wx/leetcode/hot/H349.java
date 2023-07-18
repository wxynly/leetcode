package com.wx.leetcode.hot;

import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

public class H349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                set1.add(num);
            }
        }
        return set1.stream().mapToInt(x -> x).toArray();
    }
}
