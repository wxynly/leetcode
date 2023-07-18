package com.wx.leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class offer3 {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> dic = new HashSet<>();
            HashMap<Object, Object> map = new HashMap<>();

            for (int num : nums) {
                if (dic.contains(num)) return num;
                dic.add(num);
            }
            return -1;
        }
    }
}
