package com.wx.leetcode.shuiyou;

import javax.sql.rowset.spi.SyncResolver;

public class Main1 {
    public static void main(String[] args) {
        String str = "abc";
        StringBuilder builder = new StringBuilder("");
        for (int i = str.length()-1; i >=0 ; i--) {
            builder.append(str.charAt(i));
        }
        System.out.println(builder.toString());
    }
}
