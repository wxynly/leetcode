package com.wx.leetcode.hot;

public class H97 {
    boolean result = false;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
        dfs(s1, s2, s3, 0, 0, 0);
        return result;
    }

    public void dfs(String s1, String s2, String s3, int index1, int index2, int index3) {
        if (index3 == s3.length()) {
            result = true;
            return;
        }
        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            dfs(s1, s2, s3, index1 + 1, index2, index3 + 1);
        }
        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            dfs(s1, s2, s3, index1, index2 + 1, index3 + 1);
        }
    }
}
