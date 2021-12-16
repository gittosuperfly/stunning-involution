package main.leetcode;

import main.leetcode.help.ListNode;

public class LC142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode l = head;
        ListNode r = head;
        while (true) {
            if (r == null || r.next == null) return null;
            l = l.next;
            r = r.next.next;
            if (l == r) break;
        }
        r = head;
        while (l != r) {
            l = l.next;
            r = r.next;
        }
        return l;
    }
}
