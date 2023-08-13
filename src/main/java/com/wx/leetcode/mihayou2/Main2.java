package com.wx.leetcode.mihayou2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {
    static long ans = 0;
    static List<List<Integer>> g;
    static int k;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        k = in.nextInt();
        g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }
        dfs(1, 0, 0);
        System.out.println(ans);
    }

    public static void dfs(int u, int fa, int len) {
        if (len <= k) {
            ans++;
        }
        boolean leaf = true;
        for (int v : g.get(u)) {
            if (v == fa) {
                continue;
            }
            leaf = false;
            dfs(v, u, len + 1);
        }
        if (leaf && len < k) {
            ans += k - len;
        }
    }
}