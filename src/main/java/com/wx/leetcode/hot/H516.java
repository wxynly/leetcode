package com.wx.leetcode.hot;
//最长回文子序列
public class H516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        //以每个i为终点
        for (int i = 0; i < len; i++) {
            //初始化每个位置为1
            dp[i][i] = 1;
            //从i向0扩散
            for (int j = i - 1; j >= 0; j--) {
                //相等在子序列+2
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    //不相等 取只加入i时，[j+1,i] 和 只加入j时，[j,i-1]的最大值
                    dp[j][i] = Math.max(dp[j + 1][i], Math.max(dp[j][i - 1], dp[j][i]));
                }
            }
        }
        return dp[0][len - 1];
    }
}
