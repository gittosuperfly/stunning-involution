package main.leetcode.help;

public class Printer {

    public static void print(ListNode link) {
        ListNode node = link;
        if (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        while (node != null) {
            System.out.print(" -> " + node.val);
            node = node.next;
        }
        System.out.println();
    }
}
