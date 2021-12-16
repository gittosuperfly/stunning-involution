package main.leetcode.mst;

import main.leetcode.help.ListNode;

public class MST02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }
}
