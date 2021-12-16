package main.leetcode;

import main.leetcode.help.ListNode;

public class LC092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode cur = res;
        for (int i = 0; i < right; i++) {
            if (i < left - 1) {
                pre = pre.next;
            }
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = null;
        pre.next = reverse(pre.next);
        pre.next.next = next;
        return res.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
