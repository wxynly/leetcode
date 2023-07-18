package com.wx.leetcode.xiecheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] num = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int size = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x % k == 0) {
                count++;
            } else {
                if (x > max) {
                    max = x;
                }
                map.put(x, map.getOrDefault(x, 0) + 1);
                num[size] = x;
                size++;
            }
        }

        for (int i = 0; i < size; i++) {
            int temp = max / k + 1;
            while (temp > 0) {
                int sub = temp * k - num[i];
                if (map.getOrDefault(sub, 0) > 0) {
                    count++;
                    map.put(num[i], map.get(num[i]) - 1);
                    map.put(sub, map.get(sub) - 1);
                    break;
                }
                temp--;
            }
        }
        System.out.println(count);
    }
}
