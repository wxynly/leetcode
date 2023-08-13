package com.wx.leetcode.hot;

//重复的子字符串
public class H459 {
    public boolean repeatedSubstringPattern(String s) {
        String c = s.substring(1,s.length()) + s.substring(0,s.length()-1);
        return c.contains(s);
    }
}
