package com.wx.leetcode.hot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class H56 {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        int[] temp = intervals[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (intervals[i][1] >= temp[0]) {
                temp[0] = Math.min(temp[0], intervals[i][0]);
            } else {
                list.add(temp);
                temp = intervals[i];
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        merge2(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

    public static int[][] merge2(int[][] intervals) {
        int length = intervals.length;
        if (length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> list = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                list.add(temp);
                temp = intervals[i];
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][]);
    }
}
