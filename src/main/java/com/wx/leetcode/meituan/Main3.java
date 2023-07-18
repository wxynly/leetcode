package com.wx.leetcode.meituan;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        String s, t;
        while (c-- > 0) {
            s = sc.next();
            t = sc.next();
            int n = s.length();
            int m = t.length();
            int ans = n;
            int same = 0;
            for (int i = 0; i < Math.min(n, m); i++) {
                if (s.charAt(i) == t.charAt(i)) {
                    same++;
                }
                ans = Math.min(i + 1 - same + (n - i + 1), ans);
            }
            System.out.println(ans);
        }
    }
}
