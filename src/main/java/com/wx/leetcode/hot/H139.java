package com.wx.leetcode.hot;

import java.util.*;
import java.util.stream.Collectors;

//单词拆分
public class H139 {
    Set<String> set;
    boolean flag = false;
    boolean[] memory;

    //回溯
    public boolean wordBreak(String s, List<String> wordDict) {
        set = wordDict.stream().collect(Collectors.toSet());
        memory = new boolean[s.length()];
        Arrays.fill(memory, true);
        check(s, 0);
        return flag;
    }

    public void check(String s, int index) {
        if (index == s.length()) {
            flag = true;
            return;
        }
        //记忆化搜索，如果当前的字串失败过，直接跳过
        if (flag || !memory[index]) {
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (set.contains(s.substring(index, i + 1))) {
                check(s, i + 1);
            }
        }
        //记忆化搜索，记录当前最后的字串失败
        memory[index] = false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }


}
