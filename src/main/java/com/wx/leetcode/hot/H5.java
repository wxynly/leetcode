package com.wx.leetcode.hot;

public class H5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        //dp[i][j] 表示 s[i][j] 是否为回文子串
        boolean[][] dp = new boolean[len][len];

        //初始化 每个单字符为回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        //长度2开始
        int j = 0;
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                j = L + i - 1;
//                //不能越界
//                if (j >= len || j <= i) {
//                    break;
//                }
//                //如果子串本身不为回文子串或者新增两边不相等
//                if (!dp[i + 1][j - 1] || s.charAt(i) != s.charAt(j)) {
//                    dp[i][j] = false;
//                } else {
//                    dp[i][j] = true;
//                    //最大长度更新
//                    if (L > maxLen) {
//                        maxLen = L;
//                        start = i;
//                    }
//                }

                //不能越界
                if (j >= len) {
                    break;
                }

                //如果子串本身不为回文子串或者新增两边不相等
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    //长度小于4
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    //最大长度更新
                    if (dp[i][j] && L > maxLen) {
                        maxLen = L;
                        start = i;
                    }
                }

            }
        }
        return s.substring(start, start + maxLen);
    }

    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > maxLen) {
                maxLen = max;
                start = i - (max - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        longestPalindrome2("babad");
    }
}
