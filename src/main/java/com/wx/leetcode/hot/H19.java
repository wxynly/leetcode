package com.wx.leetcode.hot;

public class H19 {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int num = 0;
        ListNode node = head;
        //遍历数量
        while (node != null) {
            num++;
            node = node.next;
        }
        int count = num - n;
        //删除头节点
        if (n == num) {
            head = head.next;
        } else {
            //倒数n+1个结点
            node = head;
            while (--count > 0) {
                node = node.next;
            }
            node.next = node.next.next;
        }

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;
        //双指针，第一个指针先走n+1步
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        //第一个指针指向Null时，第二个指针在倒数第n+1个位置
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }
}
