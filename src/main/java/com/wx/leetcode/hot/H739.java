package com.wx.leetcode.hot;

import java.util.Stack;

//每日温度
public class H739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        //求大值 栈顶到栈低递增顺序
        for (int i = 0; i < temperatures.length; i++) {
            //栈为空 或者 当前温度小于等于栈顶 直接加入
            if (stack.empty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                //栈内数据为旧值 当前温度为后续第一个大于栈顶的温度 弹出栈内所有小于当前温度的值 清除过期数据
                while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

//        for (int i = 0; i < temperatures.length; i++) {
//            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
//                res[stack.peek()] = i - stack.peek();
//                stack.pop();
//            }
//            stack.push(i);
//        }
        return res;
    }
}
