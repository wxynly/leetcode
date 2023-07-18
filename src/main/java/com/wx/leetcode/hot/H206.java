package com.wx.leetcode.hot;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class H206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }
}
