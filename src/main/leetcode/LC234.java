package main.leetcode;

import main.leetcode.help.Linked;
import main.leetcode.help.ListNode;
import main.leetcode.help.Printer;

import java.util.Stack;

public class LC234 {

    public static void main(String[] args) {
        Linked linked = new Linked();
        linked.lastAdd(1);
        linked.lastAdd(2);
        linked.lastAdd(3);
        linked.lastAdd(4);
        linked.lastAdd(5);
        linked.lastAdd(4);
        linked.lastAdd(3);
        linked.lastAdd(2);
        linked.lastAdd(1);
        System.out.println(new LC234().isPalindrome(linked.getHead()));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        //cur指向当前要反转的节点，pre指向cur的前一个节点
        ListNode cur = head, pre = null;
        while (fast != null && fast.next != null) {
            cur = slow;     //当前节点

            slow = slow.next;
            fast = fast.next.next;

            cur.next = pre; //把当前节点的next 指向 前一个节点
            pre = cur;      //前一个节点 赋值为 当前节点
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (cur != null && slow != null) {
            if (cur.val != slow.val) {
                return false;
            }
            slow = slow.next;
            cur = cur.next;
        }
        return true;
    }


}
