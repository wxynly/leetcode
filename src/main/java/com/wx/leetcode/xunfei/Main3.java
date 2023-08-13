package com.wx.leetcode.xunfei;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
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
        int[][] flag = new int[n][n];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder(a[i] + "-");
            set.add(s.toString());
            for (int j = i + 1; j < n; j++) {
                s.append(a[j]).append("-");
                set.add(s.toString());
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder(b[i] + "-");
            set.add(s.toString());
            for (int j = i + 1; j < n; j++) {
                s.append(b[j]).append("-");
                set.add(s.toString());
            }
        }
        System.out.println(set.size());
    }

}
