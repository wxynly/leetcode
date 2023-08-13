package com.wx.leetcode.yongyou;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main1 {
    public static void main(String[] args) {
        int[][] ints = {{1,2},{1,3},{2,1}};
        maxValue(ints);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public static void maxValue (int[][] interviews) {
        Arrays.sort(interviews, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1]-o1[1];
                }
                return o1[0] - o2[0];
            }
        });
    }
}
