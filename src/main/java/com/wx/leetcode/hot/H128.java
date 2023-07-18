package com.wx.leetcode.hot;

import java.util.HashSet;
import java.util.Set;

public class H128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (Integer integer : set) {
            if (!set.contains(integer-1)){
                int curNum = integer;
                int curLen = 1;
                while (set.contains(curNum+1)){
                    curNum+=1;
                    curLen++;
                }
                maxLen = Math.max(maxLen,curLen);
            }
        }
        return maxLen;
    }
}
