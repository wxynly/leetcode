package com.wx.leetcode.xiecheng;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void sort(List<String> list) {
        Collections.sort(list, (o1, o2) -> {
            if (o1 == null || o2 == null) {
                return 0;
            }
//            if (o1 == "" || o2 == "") {
//                return 0;
//            }
            return o1.compareTo(o2);
        });
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("aaa", "abc", "", " ", null);
        sort(strs);
        for (String str : strs) {
            System.out.print(str + "-");
        }
    }
}
