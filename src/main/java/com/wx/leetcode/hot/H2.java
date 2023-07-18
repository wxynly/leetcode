package com.wx.leetcode.hot;

public class H2 {

    public class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode nextNode = null;
        int res = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            sum = a + b + res;
            res = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            if (head == null) {
                head = node;
                nextNode = head;
            } else {
                nextNode.next = node;
                nextNode = node;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (res > 0) {
            nextNode.next = new ListNode(res);
        }
        return head;
    }

}
