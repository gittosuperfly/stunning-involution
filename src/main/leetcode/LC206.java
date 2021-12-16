package main.leetcode;

import main.leetcode.help.ListNode;

public class LC206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseListDG(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode newHead = reverseListDG(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
