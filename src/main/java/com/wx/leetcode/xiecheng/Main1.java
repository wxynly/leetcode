package com.wx.leetcode.xiecheng;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int a, b;
        int count = 0;
        for (int i = 0; i < s.length()-1; i++) {
            a = s.charAt(i);
            b = s.charAt(s.length()-1);
            if ((a + b) % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
