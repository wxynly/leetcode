package com.wx.leetcode.hot;

public class H707 {
    static class ListNode {
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

    class MyLinkedList {

        int size;
        ListNode dummyNode;

        ListNode tail;

        public MyLinkedList() {
            this.size = 0;
            this.dummyNode = new ListNode();
            this.tail = null;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode cur = dummyNode;
            while (index-- >= 0) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val, dummyNode.next);
            dummyNode.next = node;
            if (tail == null) {
                tail = node;
            }
            size++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            if (size == 0) {
                dummyNode.next = node;
            } else {
                tail.next = node;
            }
            tail = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            } else if (index <= 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else {
                ListNode cur = dummyNode;
                while (index-- > 0) {
                    cur = cur.next;
                }
                cur.next = new ListNode(val, cur.next);
                size++;
            }

        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                ListNode cur = dummyNode;
                ListNode pre = dummyNode;
                while (index-- >= 0) {
                    pre = cur;
                    cur = cur.next;

                }
                pre.next = cur.next;
                if (index == size - 1) {
                    tail = pre;
                }

                size--;
            }
        }
    }
}
