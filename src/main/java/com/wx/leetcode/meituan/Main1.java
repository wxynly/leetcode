package com.wx.leetcode.meituan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int t = Integer.parseInt(sc.next());
        t=100;
        int[][] flag = new int[n][n];
        for (int i = 0; i < n; i++) {
            flag[i][i] = 1;
        }
        int left, right;
        while (t-- > 0) {
            String s = sc.next();
            int num = Integer.parseInt(sc.next()) - 1;
            if (s.equals("L")) {
                if(num>0){
                    flag[num - 1][num] = flag[num][num - 1] = 1;
                }
            } else if (s.equals("R")) {
                if(num<n-1){
                    flag[num + 1][num] = flag[num][num + 1] = 1;
                }
            } else {
                left = right = num;
                while (left > 0 && flag[num][left - 1] == 1) {
                    left--;
                }
                while (right < n - 1 && flag[num][right + 1] == 1) {
                    right++;
                }
                left++;
                right++;
                System.out.println(left + " " + right);
            }
        }
    }
}
