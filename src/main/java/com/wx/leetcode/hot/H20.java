package com.wx.leetcode.hot;

import java.util.Stack;

public class H20 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(' || c == '}' && pop != '{' || c == ']' && pop != '[') {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
