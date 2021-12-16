package main.leetcode;

import main.leetcode.help.Linked;
import main.leetcode.help.ListNode;
import main.leetcode.help.Printer;

public class LC725 {
    public static void main(String[] args) {
        Linked linked = new Linked();
        linked.lastAdd(1);
        linked.lastAdd(2);
        linked.lastAdd(3);
        linked.lastAdd(4);
        linked.lastAdd(5);
        linked.lastAdd(6);
        linked.lastAdd(7);
        linked.lastAdd(8);
        ListNode[] nodes = new LC725().splitListToParts(linked.getHead(), 3);
        for (ListNode node : nodes) {
            Printer.print(node);
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        float childLength = size / ((float) k);
        int addSize = size - ((int) childLength) * k;
        ListNode[] nodes = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            nodes[i] = cur;
            int length = addSize > 0 ? ((int) childLength) + 1 : ((int) childLength);
            addSize--;
            for (int j = 1; j < length; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return nodes;
    }
}
