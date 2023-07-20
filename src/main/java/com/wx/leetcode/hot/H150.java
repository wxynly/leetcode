package com.wx.leetcode.hot;

import java.util.Stack;

public class H150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int a, b;
            if (token.equals("+")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
