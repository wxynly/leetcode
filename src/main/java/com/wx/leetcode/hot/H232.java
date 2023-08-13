package com.wx.leetcode.hot;

import java.util.Stack;

//用栈实现队列
public class H232 {
    class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;
        int size;

        public MyQueue() {
            in = new Stack();
            out = new Stack();
            size = 0;
        }

        public void push(int x) {
            in.push(x);
            size++;
        }

        public int pop() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            size--;
            return out.pop();
        }

        public int peek() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return size == 0;
        }
    }
}
