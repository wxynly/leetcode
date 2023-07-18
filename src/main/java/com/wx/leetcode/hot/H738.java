package com.wx.leetcode.hot;

public class H738 {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        boolean flag = true;
        int index = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                flag = false;
                index = i;
            }
        }
        if (flag) {
            return n;
        }
        for (int i = index + 1; i < chars.length; i++) {
            chars[i] = '9';
        }
        chars[index] = (char) (chars[index] - 1);
        for (int i = index-1; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i + 1] = '9';
                chars[i] = (char) (chars[i] - 1);
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println((char) ('9' - 1));
        System.out.println((char) ('9' - '1'));
        System.out.println(('9' - '1'));
    }
}
