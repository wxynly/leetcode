package com.wx.leetcode.hot;

import java.util.HashMap;
import java.util.Map;

public class H3 {
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() < 2) {
//            return s.length();
//        }
//        int start = 0, end = 1;
//        int max = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        map.put(s.charAt(start), start);
//        while (end < s.length()) {
//            if (map.containsKey(s.charAt(end))) {
//                if (end - start > max) {
//                    max = end - start;
//                }
//                int pos = map.get(s.charAt(end));
//                start = Math.max(start, pos) + 1;
//            }
//            map.put(s.charAt(end), end);
//            end++;
//        }
//
//        return max > end - start ? max : end - start;
//    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int start = 0, end = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                //重复的位置在start后时才做改变，相当于start之前的已经无效
                int pos = map.get(s.charAt(end));
                if (pos >= start) {
                    max = Math.max(max, end - start);
                    //直接跳到重复的下一个位置，因为start+1到重复间的长度一定更小
                    start = pos + 1;
                }
            }
            //刷新重复的位置
            map.put(s.charAt(end), end);
            end++;
        }

        return max > end - start ? max : end - start;
    }
}
