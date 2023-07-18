package com.wx.leetcode.huawei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();
//        sc.next();
        int n = sc.nextInt();
        sc.nextLine();
        String k = sc.nextLine();
        long max = 0;
        for (int i = 0; i < m.length(); i++) {
            for (int j = i; j < m.length(); j++) {
                long num = Long.parseLong(m.substring(i, j - i + 1));
                long result = 0;
                if (k.equals("+")) {
                    result = num + n;
                } else if (k.equals("-")) {
                    result = num - n;
                } else {
                    result = num * n;
                }

                String a = result + "";
                int r = 0, l = a.length() - 1;
                while (r <= l) {
                    if (a.charAt(r) == a.charAt(l)) {
                        r++;
                        l--;
                    } else {
                        break;
                    }
                }
                if (r > l && result > max) {
                    max = result;
                }

            }
        }
        System.out.println(max);
    }
}
