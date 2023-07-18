package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

//分割回文串
public class H131 {
   static List<List<String>> res = new ArrayList<>();
   static List<String> list = new ArrayList<>();

    public static List<List<String>> partition(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        computePalindrome(s, isPalindrome);
        dfs2(s, 0, isPalindrome);
        return res;
    }

    public void dfs(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
        }
        //先横向切割，如果是回文串，再纵向递归深搜
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                dfs(s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void dfs2(String s, int index, boolean[][] isPalindrome) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome[i][index]) {
                list.add(s.substring(index, i + 1));
                dfs2(s, i + 1, isPalindrome);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void computePalindrome(String s, boolean[][] isPalindrome) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    isPalindrome[j][i] = isPalindrome[i][j] = true;
                } else if (i - j == 1) {
                    isPalindrome[j][i] = isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isPalindrome[j][i] = isPalindrome[i][j] = ((s.charAt(i) == s.charAt(j)) && isPalindrome[i - 1][j + 1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        partition(s);
    }

}
