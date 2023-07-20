package com.wx.leetcode.hot;

public class H383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] num = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            num[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            num[magazine.charAt(i) - 'a']--;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
