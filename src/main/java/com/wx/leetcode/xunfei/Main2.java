package com.wx.leetcode.xunfei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        for (int i = 1; i < n; i++) {
            if (k < 0) {
                System.out.println(-1);
                return;
            }
            int sub = s.charAt(i) - s.charAt(i - 1);
            k -= sub;
        }
        System.out.println(k);
    }
}
