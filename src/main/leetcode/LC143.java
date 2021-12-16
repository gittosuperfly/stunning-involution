package main.leetcode;

import main.leetcode.help.Linked;
import main.leetcode.help.ListNode;
import main.leetcode.help.Printer;

import java.util.LinkedList;

public class LC143 {
    public static void main(String[] args) {
        Linked linked = new Linked();
        linked.lastAdd(1);
        linked.lastAdd(2);
        linked.lastAdd(3);
        linked.lastAdd(4);
        new LC143().reorderList2(linked.getHead());
        Printer.print(linked.getHead());
    }

    public void reorderList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int i = 0, j = list.size() - 1;

        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            //偶数个节点的情况，会提前相遇
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newLink = slow.next;

        slow.next = null;
        newLink = reverseList(newLink);

        while (newLink != null) {
            ListNode temp = newLink.next;
            newLink.next = head.next;
            head.next = newLink;
            head = newLink.next;
            newLink = temp;
        }
    }

    private ListNode reverseList(ListNode head) {
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
