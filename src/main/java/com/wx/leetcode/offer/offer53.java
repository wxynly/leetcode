package com.wx.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class offer53 {
    class Solution {
        public int search(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }
            return map.containsKey(target) ? map.get(target) : 0;
        }
    }
}
