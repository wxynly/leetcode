package com.wx.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

public class H93 {
    static List<String> result = new ArrayList<String>();

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
        System.out.println(result.toString());
    }

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() <= 12) {
            find(s, 0, 1, new StringBuilder());
        }
        return result;
    }

    public static void find(String s, int start, int num, StringBuilder res) {
        if (num == 4) {
            if (check(s, start, s.length() - 1)) {
                result.add(res.append(s.substring(start)).toString());
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (check(s, start, i)) {
//                String temp = res;
                int len = res.length();
//                res += s.substring(start, i + 1) + ".";
                res.append(s, start, i + 1).append(".");
                num++;
                find(s, i + 1, num, res);
                num--;
                res.delete(len, res.length());
//                res = temp;
            } else {
                break;
            }
        }
    }

    public static boolean check(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        if (end - start > 3) {
            return false;
        }

        int value = Integer.parseInt(s.substring(start, end + 1));
        return value <= 255;

//        int num = 0;
//        for (int i = start; i <= end; i++) {
//            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
//                return false;
//            }
//            num = num * 10 + (s.charAt(i) - '0');
//            if (num > 255) { // 如果⼤于255了不合法
//                return false;
//            }
//        }
//        return true;
    }


}
