package com.wx.leetcode.hot;

public class H21 {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode next1;
        ListNode pre2 = null;
        ListNode now2 = list2;

        //将l1插入l2
        while (list1 != null && now2 != null) {
            //l1值大于l2值时,l2继续往后走
            if (list1.val >= now2.val) {
                pre2 = now2;
                now2 = now2.next;
            } else {
                //记录l1下一个位置
                next1 = list1.next;
                //如果在l2表头前插入
                if (pre2 == null) {
                    //l1值作为新表头
                    list1.next = list2;
                    list2 = list1;
                } else {
                    //l1的后引用指向l2
                    list1.next = pre2.next;
                    //l2前值的后引用指向l1
                    pre2.next = list1;
                }
                //l2前值更新为l1
                pre2 = list1;
                //l1往后走一位
                list1 = next1;

            }
        }

        //如果l2空了，直接接上l1
        if (now2 == null) {
            pre2.next = list1;
        }

        return list2;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        //合并列表头节点
        ListNode head = new ListNode();
        ListNode pre = head;
        while (list1 != null && list2 != null) {
            //每次pre连接当前更小的那个结点，然后小的结点往后走
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            //pre更新为当前结点
            pre = pre.next;
        }

        //将不为null的结点直接接在最后面
        pre.next = list1 == null ? list2 : list1;
        return head.next;
    }

    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        //每次返回不为空或者值小的那个
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            //找下一个更小值
            list1.next = mergeTwoLists3(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists3(list1, list2.next);
            return list2;
        }
    }
}
