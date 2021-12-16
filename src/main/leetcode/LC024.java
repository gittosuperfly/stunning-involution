package main.leetcode;

import main.leetcode.help.ListNode;

public class LC024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairsDT(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = temp;
            pre = head;
            head = head.next;
        }
        return res.next;
    }
}
