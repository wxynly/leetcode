package com.wx.leetcode.hot;

public class H541 {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i += 2 * k) {
            int start = i;
            int end = Math.min(start + k - 1, len - 1);
            while (start < end) {
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
