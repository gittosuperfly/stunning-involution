package main.leetcode;

import main.leetcode.help.ListNode;

public class LC082 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while (head != null && head.next != null) {
            if (head.next.val == head.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return res;
    }
}
