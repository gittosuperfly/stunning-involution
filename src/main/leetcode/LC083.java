package main.leetcode;

import main.leetcode.help.Linked;
import main.leetcode.help.ListNode;
import main.leetcode.help.Printer;

import java.util.HashMap;
import java.util.HashSet;

public class LC083 {

    public static void main(String[] args) {
        Linked linked = new Linked();
        linked.lastAdd(1);
        linked.lastAdd(1);
        linked.lastAdd(1);
        linked.lastAdd(2);
        linked.lastAdd(3);
        linked.lastAdd(4);
        linked.lastAdd(4);
        linked.lastAdd(5);
        Printer.print(new LC083().deleteDuplicates(linked.getHead()));
    }

    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            map.put(temp.val, map.containsKey(temp.val) ? map.get(temp.val) + 1 : 1);
            temp = temp.next;
        }

        while (head != null) {
            if (map.get(head.val) > 1) {
                head = head.next;
            } else {
                break;
            }
        }
        temp = head;
        while (temp != null && temp.next != null) {
            if (map.get(temp.next.val) > 1) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
