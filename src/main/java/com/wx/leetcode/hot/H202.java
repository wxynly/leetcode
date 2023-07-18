package com.wx.leetcode.hot;

import java.util.HashSet;
import java.util.Set;

public class H202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = getNext(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int getNext(int n) {
        int sum = 0;
        int res = 0;
        while (n != 0) {
            res = n % 10;
            sum += res * res;
            n = n / 10;
        }
        return sum;
    }
}
