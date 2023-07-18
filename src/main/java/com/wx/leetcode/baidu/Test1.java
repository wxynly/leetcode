package com.wx.leetcode.baidu;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int temp;
        int index = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            temp = 0;
            for (int i = 0; i < 1000000; i++) {
                temp += i;
                if (temp > x) {
                    temp -= i;
                    index = i - 1;
                    break;
                }
            }
            if (count == 1) {
                for (int i = 0; i < index; i++) {
                    sb.append("r");
                }
                count++;
            } else if (count == 2) {
                for (int i = 0; i < index; i++) {
                    sb.append("e");
                }
                count++;
            } else {
                for (int i = 0; i < index; i++) {
                    sb.append("d");
                }
                count = 1;
            }
            x = x - temp;
        }
        System.out.println(sb.toString());
    }

}
