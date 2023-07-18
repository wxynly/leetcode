package com.wx.leetcode.hot;

import java.util.ArrayDeque;
import java.util.Deque;

public class H1047 {
    public static String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        if (s.length() < 2) {
            return s;
        }
        int x = 0;
        while (x < s.length()) {
            if (deque.isEmpty()) {
                deque.push(s.charAt(x));
            } else {
                if (deque.peek() == s.charAt(x)) {
                    deque.pop();
                }else {
                    deque.push(s.charAt(x));
                }
            }
            x++;
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pollFirst());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }
}
