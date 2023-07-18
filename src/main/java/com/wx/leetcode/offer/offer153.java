package com.wx.leetcode.offer;

public class offer153 {
    class Solution {
        public int minArray(int[] numbers) {
            int left = 0;
            int right = numbers.length - 1;
            int mid = 0;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (numbers[mid] > numbers[right]) {
                    left = mid + 1;
                } else if (numbers[mid] < numbers[right]) {
                    right = mid;
                } else {
                    right--;
                }
            }
            return numbers[left];
        }
    }
}
