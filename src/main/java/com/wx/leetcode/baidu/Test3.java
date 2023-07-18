package com.wx.leetcode.baidu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String s;
        Set<String> set = new HashSet<>();
        sc.nextLine();
        while (x-- > 0) {
            s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = s.indexOf(' ') + 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (set.contains(sb.toString())) {
                        System.out.println("No");
                    } else {
                        set.add(sb.toString());
                        System.out.println("Yes");
                    }
                    break;
                }

                if (s.charAt(i) == ' ') {
                    while (s.charAt(i + 1) != ',' && s.charAt(i + 1) != ')') {
                        i++;
                    }
                    continue;
                }
                sb.append(s.charAt(i));
            }
        }
    }
    void f(){

    }
}
