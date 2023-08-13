package com.wx.leetcode.xiaohongshu;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strNum = s.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String c : strNum) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<String[]> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                String[] temp = new String[2];
                temp[0] = entry.getKey();
                temp[1] = String.valueOf(entry.getValue());
                list.add(temp);
            }
        }
        String[][] res = list.toArray(new String[0][]);
        Arrays.sort(res, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                    return o1[0].compareTo(o2[0]);
                }
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        for (String[] x : res) {
            System.out.println(x[0]);
        }
    }
}
