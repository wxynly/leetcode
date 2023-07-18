package com.wx.leetcode.huawei;

import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        boolean flag2 = false;
        int x = 0;
        while (sc.hasNextInt()||flag2) {
            if(!flag2){
                x = sc.nextInt();
            }
            if (stack.size() > 0) {
                int n = stack.peek();
                boolean flag = true;
                if (x == n) {
                    stack.pop();
                    stack.push(x * 2);
                    flag = false;
                }
                if (flag) {
                    long sum = 0;
                    for (int i = stack.size() - 1; i >= 0; i--) {
                        sum += stack.get(i);
                        if (sum > x) {
                            break;
                        }
                        if (sum == x) {
                            int count = stack.size() - 1 - i;
                            while (count-- >= 0) {
                                stack.pop();
                            }
                            stack.push(x * 2);
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    stack.push(x);
                }
            } else {
                stack.push(x);
            }
        }
        while (stack.size() > 1) {
            System.out.print(stack.pop() + " ");
        }
        System.out.print(stack.pop());
    }
}
