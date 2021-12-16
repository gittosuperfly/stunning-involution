package main.leetcode;

import main.leetcode.help.ListNode;

public class LC328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddTail = head;
        ListNode evenHead = head.next, evenTail = evenHead;
        ListNode nextPair = head.next.next;
        while (nextPair != null) {
            oddTail.next = nextPair;
            oddTail = oddTail.next;
            nextPair = nextPair.next;
            if (nextPair != null) {
                evenTail.next = nextPair;
                evenTail = evenTail.next;
                nextPair = nextPair.next;
            }
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return head;
    }
}
