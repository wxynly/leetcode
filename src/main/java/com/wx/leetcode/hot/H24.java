package com.wx.leetcode.hot;


public class H24 {
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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        ListNode first, second, third;
        while (cur.next != null && cur.next.next != null) {
            third = cur.next.next.next;
            first = cur.next;
            second = cur.next.next;
            first.next = third;
            second.next = first;
            cur.next = second;
            cur = first;
        }
        return dummy.next;
    }

}
