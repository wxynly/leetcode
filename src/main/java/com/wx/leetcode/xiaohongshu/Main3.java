package com.wx.leetcode.xiaohongshu;

import java.util.Scanner;

public class Main3 {
    static int res = Integer.MIN_VALUE;
    static int n;
    static boolean[] flag;
    static boolean[][] con;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        con = new boolean[n][n];
        flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int u, v;
        for (int i = 0; i < n - 1; i++) {
            u = sc.nextInt() - 1;
            v = sc.nextInt() - 1;
            con[u][v] = con[v][u] = true;
        }
        dfs(0, 0);
        System.out.println(res);
    }

    public static void dfs(int index, int sum) {
//        if (index == n) {
//            res = Math.max(res, sum);
//            return;
//        }
        for (int i = index; i < n; i++) {
            //都为白色，有连接，和是质数
            if (i != index && !flag[index] && !flag[i] && con[i][index] && isPrime(a[i] + a[index])) {
                flag[i] = true;
                dfs(index, sum + 1);
                res = Math.max(res, sum + 1);
                flag[i] = false;

                flag[index] = true;
                dfs(i + 1, sum + 1);
                res = Math.max(res, sum + 1);
                flag[index] = false;
            }
        }

    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
