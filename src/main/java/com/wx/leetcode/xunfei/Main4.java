package com.wx.leetcode.xunfei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int count = 0;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                boolean found = false;
                for (int j = 0; j <= n - len; j++) {
                    boolean match = true;
                    for (int k = 0; k < len; k++) {
                        if (a[i + k] != b[j + k]) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
