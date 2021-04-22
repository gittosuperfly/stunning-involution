package leetcode;

import leetcode.help.Linked;
import leetcode.help.ListNode;
import leetcode.help.Printer;

public class LC002 {

    //Test
    public static void main(String[] args) {
        Linked l1 = new Linked();
        l1.lastAdd(2);
        l1.lastAdd(3);
        l1.lastAdd(5);

        Linked l2 = new Linked();
        l2.lastAdd(5);
        l2.lastAdd(7);
        l2.lastAdd(5);
        l2.lastAdd(1);

        Printer.print(addTwoNumbers(l1.getHead(), l2.getHead()));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, temp = result;
        //进位
        int nextAdd = 0;
        //直到两个链表都遍历完
        while (p != null || q != null) {

            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int add = nextAdd + x + y;
            nextAdd = add / 10;
            temp.next = new ListNode(add % 10);
            temp = temp.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (nextAdd != 0) {
            temp.next = new ListNode(nextAdd);
        }
        return result.next;
    }
}
