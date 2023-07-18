package com.wx.leetcode.hot;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//下一个更大元素 I
public class H496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len2; i++) {
            while (!stack.empty() && nums2[i] > nums2[stack.peek()]) {
                map.put(nums2[stack.peek()], nums2[i]);
                stack.pop();
            }
            stack.push(i);
        }
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
