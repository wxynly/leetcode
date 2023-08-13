package com.wx.leetcode.xunfei;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] res = find(n);
        for (int i : res) {
            System.out.println(i + " ");
        }
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + " ");
        }
    }

    public static int[] find(int n) {
        int[] res = new int[n];
        boolean[] used = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!used[n - i + 1]) {
                res[i - 1] = n - i + 1;
                used[n - i + 1] = true;
            } else {
                for (int j = 0; j >= 1; j--) {
                    if (!used[j]) {
                        res[i - 1] = j;
                        used[j] = true;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
